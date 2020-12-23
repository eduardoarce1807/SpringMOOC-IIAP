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

import com.MOOCIIAP.demo.models.entity.Sesion;
import com.MOOCIIAP.demo.services.SesionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sesiones")
public class SesionController {

	@Autowired
	private SesionService sesionService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return sesionService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Sesion s) {
		System.out.println("Crear: " + s.getTitulo());
		return sesionService.create(s);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return sesionService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/id-curso")
	public Map<String, Object> readByCursoId(@RequestParam(value = "id") int id) {
		try {
			return sesionService.readByCursoId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/id-modulo")
	public Map<String, Object> readByModuloId(@RequestParam(value = "id") int id) {
		try {
			return sesionService.readByModuloId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Sesion s, @PathVariable int id) {
		Sesion ses = new Sesion();

		ses.setId_sesion(id);

		if (s.getTitulo() != null) {
			ses.setTitulo(s.getTitulo());
		}
		if (s.getDescripcion() != null) {
			ses.setDescripcion(s.getDescripcion());
		}
		if (s.getId_modulo_fk() != 0) {
			ses.setId_modulo_fk(s.getId_modulo_fk());
		}

		return sesionService.update(ses);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return sesionService.delete(id);
	}

}
