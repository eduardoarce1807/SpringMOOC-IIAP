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

import com.MOOCIIAP.demo.models.entity.Respuesta;
import com.MOOCIIAP.demo.services.RespuestaService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/respuestas")
public class RespuestaController {

	@Autowired
	private RespuestaService respuestaService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return respuestaService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Respuesta r) {
		System.out.println("Crear: " + r.getId_alternativa_fk());
		return respuestaService.create(r);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return respuestaService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Respuesta r, @PathVariable int id) {
		Respuesta resp = new Respuesta();
		resp.setId_respuesta(id);
		if(r.getId_alternativa_fk() != 0) {
			resp.setId_alternativa_fk(r.getId_alternativa_fk());
		}
		if(r.getId_inscripcion_fk() != 0) {
			resp.setId_inscripcion_fk(r.getId_inscripcion_fk());
		}
		return respuestaService.update(resp);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return respuestaService.delete(id);
	}
	
}
