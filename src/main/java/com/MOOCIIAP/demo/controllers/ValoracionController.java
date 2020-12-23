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

import com.MOOCIIAP.demo.models.entity.Valoracion;
import com.MOOCIIAP.demo.services.ValoracionService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/valoraciones")
public class ValoracionController {

	@Autowired
	private ValoracionService valoracionService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return valoracionService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Valoracion v) {
		System.out.println("Crear: " + v.getComentario());
		return valoracionService.create(v);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return valoracionService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Valoracion v, @PathVariable int id) {
		Valoracion val = new Valoracion();
		val.setId_valoracion(id);
		if(v.getN_estrellas() != null) {
			val.setN_estrellas(v.getN_estrellas());
		}
		if(v.getComentario() != null) {
			val.setComentario(v.getComentario());
		}
		if(v.getId_usuario_fk() != 0) {
			val.setId_usuario_fk(v.getId_usuario_fk());
		}
		if(v.getId_curso_fk() != 0) {
			val.setId_curso_fk(v.getId_curso_fk());
		}
		return valoracionService.update(val);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return valoracionService.delete(id);
	}
	
}
