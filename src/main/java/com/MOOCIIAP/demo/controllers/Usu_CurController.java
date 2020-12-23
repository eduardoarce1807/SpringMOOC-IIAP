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

import com.MOOCIIAP.demo.models.entity.Usu_Cur;
import com.MOOCIIAP.demo.services.Usu_CurService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usu-cur")
public class Usu_CurController {

	@Autowired
	private Usu_CurService usu_curService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return usu_curService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Usu_Cur u_c) {
		return usu_curService.create(u_c);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return usu_curService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/id-usu")
	public Map<String, Object> readByUsuId(@RequestParam(value = "id") int id) {
		try {
			return usu_curService.readByUsuId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/id-cur")
	public Map<String, Object> readByCurId(@RequestParam(value = "id") int id) {
		try {
			return usu_curService.readByCurId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Usu_Cur u_c, @PathVariable int id) {
		Usu_Cur usu_cur = new Usu_Cur();
		usu_cur.setId_usu_cur(id);
		if (u_c.getId_curso_fk() != 0) {
			usu_cur.setId_curso_fk(u_c.getId_curso_fk());
		}
		if (u_c.getId_usuario_fk() != 0) {
			usu_cur.setId_usuario_fk(u_c.getId_usuario_fk());
		}
		return usu_curService.update(usu_cur);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return usu_curService.delete(id);
	}

}
