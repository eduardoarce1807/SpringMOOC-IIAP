package com.MOOCIIAP.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MOOCIIAP.demo.models.entity.Rol;
import com.MOOCIIAP.demo.services.RolService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return rolService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Rol r) {
		System.out.println("Crear: " + r.getNombre());
		return rolService.create(r);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return rolService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Rol r, @PathVariable int id) {
		Rol rol = new Rol();
		rol.setId_rol(id);
		if(r.getNombre() != null) {
			rol.setNombre(r.getNombre());
		}
		return rolService.update(rol);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return rolService.delete(id);
	}
	
}
