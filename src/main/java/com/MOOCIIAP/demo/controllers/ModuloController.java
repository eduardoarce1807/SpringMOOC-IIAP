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

import com.MOOCIIAP.demo.models.entity.Modulo;
import com.MOOCIIAP.demo.services.ModuloService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/modulos")
public class ModuloController {

	@Autowired
	private ModuloService moduloService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return moduloService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Modulo m) {
		System.out.println("Crear: " + m.getTitulo());
		return moduloService.create(m);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return moduloService.read(id);
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
			return moduloService.readByCursoId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Modulo m, @PathVariable int id) {
		Modulo mod = new Modulo();
		mod.setId_modulo(id);
		if (m.getTitulo() != null) {
			mod.setTitulo(m.getTitulo());
		}
		if (m.getDescripcion() != null) {
			mod.setDescripcion(m.getDescripcion());
		}
		return moduloService.update(mod);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return moduloService.delete(id);
	}

}
