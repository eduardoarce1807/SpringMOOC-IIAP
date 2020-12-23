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

import com.MOOCIIAP.demo.models.entity.Rec_Ap;
import com.MOOCIIAP.demo.services.Rec_ApService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/recs-ap")
public class Rec_ApController {

	@Autowired
	private Rec_ApService rec_apService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return rec_apService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Rec_Ap r_a) {
		System.out.println("Crear: " + r_a.getNota());
		return rec_apService.create(r_a);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return rec_apService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	// Read
		@GetMapping("/id-sesion")
		public Map<String, Object> readBySesionId(@RequestParam(value = "id") int id) {
			try {
				return rec_apService.readBySesionId(id);
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
			return rec_apService.readByCursoId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Rec_Ap r_a, @PathVariable int id) {
		Rec_Ap rec_ap = new Rec_Ap();
		rec_ap.setId_rec_ap(id);
		if (r_a.getTitulo() != null) {
			rec_ap.setTitulo(r_a.getTitulo());
		}
		if (r_a.getNota() != 0) {
			rec_ap.setNota(r_a.getNota());
		}
		if (r_a.getUrl() != null) {
			rec_ap.setUrl(r_a.getUrl());
		}
		if (r_a.getCompletada() != null) {
			rec_ap.setCompletada(r_a.getCompletada());
		}
		if (r_a.getId_sesion_fk() != 0) {
			rec_ap.setId_sesion_fk(r_a.getId_sesion_fk());
		}
		if (r_a.getId_tipo_rec_ap_fk() != 0) {
			rec_ap.setId_tipo_rec_ap_fk(r_a.getId_tipo_rec_ap_fk());
		}
		if (r_a.getId_rubrica_fk() != 0) {
			rec_ap.setId_rubrica_fk(r_a.getId_rubrica_fk());
		}
		return rec_apService.update(rec_ap);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return rec_apService.delete(id);
	}

}
