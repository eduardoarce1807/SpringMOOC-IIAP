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

import com.MOOCIIAP.demo.models.entity.Alternativa;
import com.MOOCIIAP.demo.services.AlternativaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alternativas")
public class AlternativaController {

	@Autowired
	private AlternativaService alternativaService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return alternativaService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Alternativa a) {
		System.out.println("Crear: " + a.getNombre());
		return alternativaService.create(a);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return alternativaService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/pregunta")
	public Map<String, Object> readByIdPregunta(@RequestParam(value = "id") int id) {
		try {
			return alternativaService.readByIdPregunta(id);
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
			return alternativaService.readByIdRecAp(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Alternativa a, @PathVariable int id) {
		Alternativa altr = new Alternativa();
		altr.setId_alternativa(id);
		if (a.getNombre() != null) {
			altr.setNombre(a.getNombre());
		}
		if (a.getCorrecta() != null) {
			altr.setCorrecta(a.getCorrecta());
		}
		if (a.getId_pregunta_fk() != 0) {
			altr.setId_pregunta_fk(a.getId_pregunta_fk());
		}
		return alternativaService.update(altr);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return alternativaService.delete(id);
	}

}
