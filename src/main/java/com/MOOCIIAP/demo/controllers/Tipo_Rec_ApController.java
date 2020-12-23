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

import com.MOOCIIAP.demo.models.entity.Tipo_Rec_Ap;
import com.MOOCIIAP.demo.services.Tipo_Rec_ApService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/tipos-rec-ap")
public class Tipo_Rec_ApController {

	@Autowired
	private Tipo_Rec_ApService tipo_rec_apService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return tipo_rec_apService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Tipo_Rec_Ap t_r_a) {
		System.out.println("Crear: " + t_r_a.getNombre());
		return tipo_rec_apService.create(t_r_a);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return tipo_rec_apService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Tipo_Rec_Ap t_r_a, @PathVariable int id) {
		Tipo_Rec_Ap tipo_rec_ap = new Tipo_Rec_Ap();
		tipo_rec_ap.setId_tipo_rec_ap(id);
		if(tipo_rec_ap.getNombre() != null) {
			tipo_rec_ap.setNombre(tipo_rec_ap.getNombre());
		}
		return tipo_rec_apService.update(tipo_rec_ap);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return tipo_rec_apService.delete(id);
	}
	
}
