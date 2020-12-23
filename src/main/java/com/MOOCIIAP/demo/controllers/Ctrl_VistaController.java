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

import com.MOOCIIAP.demo.models.entity.Ctrl_Vista;
import com.MOOCIIAP.demo.services.Ctrl_VistaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ctrl-vistas")
public class Ctrl_VistaController {

	@Autowired
	private Ctrl_VistaService ctrl_vistaService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return ctrl_vistaService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Ctrl_Vista c_v) {
		System.out.println("Crear: " + c_v.getVisto());
		return ctrl_vistaService.create(c_v);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return ctrl_vistaService.read(id);
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
			return ctrl_vistaService.readByIdRecAp(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Ctrl_Vista c_v, @PathVariable int id) {
		Ctrl_Vista ctrl_vista = new Ctrl_Vista();
		ctrl_vista.setId_ctrl_vista(id);
		if (c_v.getVisto() != null) {
			ctrl_vista.setVisto(c_v.getVisto());
		}
		if (c_v.getId_inscripcion_fk() != 0) {
			ctrl_vista.setId_inscripcion_fk(c_v.getId_inscripcion_fk());
		}
		if (c_v.getId_rec_ap_fk() != 0) {
			ctrl_vista.setId_rec_ap_fk(c_v.getId_rec_ap_fk());
		}
		return ctrl_vistaService.update(ctrl_vista);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return ctrl_vistaService.delete(id);
	}

}
