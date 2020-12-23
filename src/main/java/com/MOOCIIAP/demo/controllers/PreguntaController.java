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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MOOCIIAP.demo.models.entity.Pregunta;
import com.MOOCIIAP.demo.services.PreguntaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

	@Autowired
	private PreguntaService preguntaService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return preguntaService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Pregunta p) {
		System.out.println("Crear: " + p.getNombre());
		return preguntaService.create(p);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return preguntaService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/rec-ap")
	public Map<String, Object> readByIdRecAp(@RequestParam(value = "id") int id) {
		try {
			return preguntaService.readByIdRecAp(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Pregunta p, @PathVariable int id) {
		Pregunta preg = new Pregunta();
		preg.setId_pregunta(id);
		if (p.getNombre() != null) {
			preg.setNombre(p.getNombre());
		}
		if (p.getId_rec_ap_fk() != 0) {
			preg.setId_rec_ap_fk(p.getId_rec_ap_fk());
		}
		return preguntaService.update(preg);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return preguntaService.delete(id);
	}

}
