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

import com.MOOCIIAP.demo.models.entity.Rubrica;
import com.MOOCIIAP.demo.services.RubricaService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/rubricas")
public class RubricaController {

	@Autowired
	private RubricaService rubricaService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return rubricaService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Rubrica r) {
		System.out.println("Crear: " + r.getNombre());
		return rubricaService.create(r);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return rubricaService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Rubrica r, @PathVariable int id) {
		Rubrica rub = new Rubrica();
		rub.setId_rubrica(id);
		if(r.getNombre() != null) {
			rub.setNombre(r.getNombre());
		}
		return rubricaService.update(rub);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return rubricaService.delete(id);
	}
	
}
