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

import com.MOOCIIAP.demo.models.entity.Categoria;
import com.MOOCIIAP.demo.services.CategoriaService;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return categoriaService.readAll();
	}
	
	//Create
	@PostMapping("/add")
	public int create(@RequestBody Categoria c) {
		System.out.println("Crear: " + c.getNombre());
		return categoriaService.create(c);
	}
	
	//Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return categoriaService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}
	
	//Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Categoria c, @PathVariable int id) {
		Categoria cat = new Categoria();
		cat.setId_categoria(id);
		cat.setNombre(c.getNombre());
		return categoriaService.update(cat);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return categoriaService.delete(id);
	}
	
}
