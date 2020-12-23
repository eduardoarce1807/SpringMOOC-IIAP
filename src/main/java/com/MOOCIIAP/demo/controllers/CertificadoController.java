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

import com.MOOCIIAP.demo.models.entity.Certificado;
import com.MOOCIIAP.demo.services.CertificadoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/certificados")
public class CertificadoController {

	@Autowired
	private CertificadoService certificadoService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return certificadoService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Certificado c) {
		System.out.println("Crear: " + c.getCodigo());
		return certificadoService.create(c);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return certificadoService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update")
	public int edit(@RequestBody Certificado c, @RequestParam(value = "cod") String cod) {
		Certificado cert = new Certificado();
		cert.setCodigo(cod);
		if (c.getId_inscripcion_fk() != null) {
			cert.setId_inscripcion_fk(c.getId_inscripcion_fk());
		}
		return certificadoService.update(cert);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return certificadoService.delete(id);
	}

}
