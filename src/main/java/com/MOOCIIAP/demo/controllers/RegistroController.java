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

import com.MOOCIIAP.demo.models.entity.Registro;
import com.MOOCIIAP.demo.services.RegistroService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/registros")
public class RegistroController {

	@Autowired
	private RegistroService registroService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return registroService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Registro r) {
		System.out.println("Crear: " + r.getNota());
		return registroService.create(r);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return registroService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Registro r, @PathVariable int id) {
		Registro reg = new Registro();
		reg.setId_registro(id);
		if(r.getNota() != 0) {
			reg.setNota(r.getNota());
		}
		if(r.getAprobado() != null) {
			reg.setAprobado(r.getAprobado());
		}
		if(r.getId_rubrica_fk() != 0) {
			reg.setId_rubrica_fk(r.getId_rubrica_fk());
		}
		if(r.getId_inscripcion_fk() != 0) {
			reg.setId_inscripcion_fk(r.getId_inscripcion_fk());
		}
		return registroService.update(reg);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return registroService.delete(id);
	}
	
}
