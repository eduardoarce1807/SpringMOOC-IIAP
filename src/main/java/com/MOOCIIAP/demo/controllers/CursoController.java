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

import com.MOOCIIAP.demo.models.entity.Curso;
import com.MOOCIIAP.demo.services.CursoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return cursoService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Curso c) {
		System.out.println("Crear: " + c.getTitulo());
		return cursoService.create(c);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return cursoService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/url")
	public Map<String, Object> readByUrl(@RequestParam(value = "url") String url) {
		try {
			return cursoService.readByUrl(url);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/usuario")
	public Map<String, Object> readByIdUsuario(@RequestParam(value = "id") int id) {
		try {
			return cursoService.readByIdUsuario(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Curso c, @PathVariable int id) {
		Curso cur = new Curso();

		cur.setId_curso(id);

		if (c.getTitulo() != null) {
			cur.setTitulo(c.getTitulo());
		}
		if (c.getSubtitulo() != null) {
			cur.setSubtitulo(c.getSubtitulo());
		}
		// Si se actualiza el precio no debe ser 0
		if (c.getPrecio() != 0) {
			cur.setPrecio(c.getPrecio());
		}
		if (c.getRuta_img() != null) {
			cur.setRuta_img(c.getRuta_img());
		}
		if (c.getRuta_vid() != null) {
			cur.setRuta_vid(c.getRuta_vid());
		}
		if (c.getUrl() != null) {
			cur.setUrl(c.getUrl());
		}
		if (c.getDuracion() != 0) {
			cur.setDuracion(c.getDuracion());
		}
		if (c.getCertificacion_tit() != null) {
			cur.setCertificacion_tit(c.getCertificacion_tit());
		}
		if (c.getCertificadora() != null) {
			cur.setCertificadora(c.getCertificadora());
		}
		if (c.getCertificadora_2() != null) {
			cur.setCertificadora_2(c.getCertificadora_2());
		}
		if (c.getObjetivo() != null) {
			cur.setObjetivo(c.getObjetivo());
		}
		if (c.getPerfil_participante() != null) {
			cur.setPerfil_participante(c.getPerfil_participante());
		}
		if (c.getMetodologia() != null) {
			cur.setMetodologia(c.getMetodologia());
		}
		if (c.getCompetencias() != null) {
			cur.setCompetencias(c.getCompetencias());
		}
		if (c.getId_categoria_fk() != 0) {
			cur.setId_categoria_fk(c.getId_categoria_fk());
		}

		return cursoService.update(cur);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return cursoService.delete(id);
	}

}
