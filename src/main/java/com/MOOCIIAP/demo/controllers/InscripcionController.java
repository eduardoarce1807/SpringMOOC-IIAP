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

import com.MOOCIIAP.demo.models.entity.Inscripcion;
import com.MOOCIIAP.demo.services.InscripcionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

	@Autowired
	private InscripcionService inscripcionService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return inscripcionService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Inscripcion i) {
		System.out.println("Crear: " + i.getNota_final());
		return inscripcionService.create(i);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return inscripcionService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/cur/{id}")
	public Map<String, Object> readByIdCur(@PathVariable int id) {
		try {
			return inscripcionService.readByIdCur(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/usu-cur")
	public Map<String, Object> readByIdCurIdUsu(@RequestParam(value = "idC") int idC,
			@RequestParam(value = "idU") int idU) {
		try {
			return inscripcionService.readByIdCurIdUsu(idC, idU);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/usux")
	public Map<String, Object> readByIdUsu(@RequestParam(value = "id") int id) {
		try {
			return inscripcionService.readByIdUsu(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Inscripcion i, @PathVariable int id) {
		Inscripcion insc = new Inscripcion();
		insc.setId_inscripcion(id);
		if (i.getNota_final() != 0) {
			insc.setNota_final(i.getNota_final());
		}
		if (i.getProgreso() != 0) {
			insc.setProgreso(i.getProgreso());
		}
		if (i.getId_curso_fk() != 0) {
			insc.setId_curso_fk(i.getId_curso_fk());
		}
		if (i.getId_usuario_fk() != 0) {
			insc.setId_usuario_fk(i.getId_usuario_fk());
		}
		return inscripcionService.update(insc);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return inscripcionService.delete(id);
	}

}
