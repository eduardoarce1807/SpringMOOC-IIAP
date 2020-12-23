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

import com.MOOCIIAP.demo.models.entity.Rol_Usu;
import com.MOOCIIAP.demo.services.Rol_UsuService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/roles-usu")
public class Rol_UsuController {

	@Autowired
	private Rol_UsuService rol_usuService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return rol_usuService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Rol_Usu r_u) {
		return rol_usuService.create(r_u);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return rol_usuService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Read por Id de usuario
		@GetMapping("/usu/{id}")
		public Map<String, Object> readUsu(@PathVariable int id) {
			try {
				return rol_usuService.readUsu(id);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("error");
				return null;
			}
		}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Rol_Usu r_u, @PathVariable int id) {
		Rol_Usu rol_usu = new Rol_Usu();
		rol_usu.setId_rol_usu(id);
		if(r_u.getId_rol_fk() != 0) {
			rol_usu.setId_rol_fk(r_u.getId_rol_fk());
		}
		if(r_u.getId_usuario_fk() != 0) {
			rol_usu.setId_usuario_fk(r_u.getId_usuario_fk());
		}
		return rol_usuService.update(rol_usu);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return rol_usuService.delete(id);
	}
	
}
