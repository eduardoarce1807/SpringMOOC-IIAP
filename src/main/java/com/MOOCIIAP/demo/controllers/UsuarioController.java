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

import com.MOOCIIAP.demo.models.entity.Usuario;
import com.MOOCIIAP.demo.services.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public Map<String, Object> readAll() {
		return usuarioService.readAll();
	}

	// Create
	@PostMapping("/add")
	public int create(@RequestBody Usuario u) {

		System.out.println("Crear: " + u.getNombres());
		System.out.println("Crear: " + u.getAp_paterno());
		return usuarioService.create(u);
	}

	// Create
	@PostMapping("/addR")
	public int createR(@RequestBody Usuario u, @RequestParam(value = "id") int id) {

		System.out.println("Crear: " + u.getNombres());
		System.out.println("Crear: " + u.getAp_paterno());
		return usuarioService.createR(u, id);
	}

	// Read
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		try {
			return usuarioService.read(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/dni")
	public Map<String, Object> readByDni(@RequestParam(value = "dni") String dni) {
		try {
			return usuarioService.readByDni(dni);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/usu")
	public Map<String, Object> readByUsu(@RequestParam(value = "usu") String usu) {
		try {
			return usuarioService.readByUsuario(usu);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Read
	@GetMapping("/cur")
	public Map<String, Object> readIByCursoId(@RequestParam(value = "id") int id) {
		try {
			return usuarioService.readIByCursoId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return null;
		}
	}

	// Update
	@PutMapping("/update/{id}")
	public int edit(@RequestBody Usuario u, @PathVariable int id) {
		Usuario usu = new Usuario();

		usu.setId_usuario(id);
		if (u.getNombres() != null) {
			usu.setNombres(u.getNombres());
		}
		if (u.getAp_paterno() != null) {
			usu.setAp_paterno(u.getAp_paterno());
		}
		if (u.getAp_materno() != null) {
			usu.setAp_materno(u.getAp_materno());
		}
		if (u.getDescripcion() != null) {
			usu.setDescripcion(u.getDescripcion());
		}
		if (u.getDni() != null) {
			usu.setDni(u.getDni());
		}
		if (u.getFecha_nacimiento() != null) {
			usu.setFecha_nacimiento(u.getFecha_nacimiento());
		}
		if (u.getSexo() != null) {
			usu.setSexo(u.getSexo());
		}
		if (u.getUsuario() != null) {
			usu.setUsuario(u.getUsuario());
		}
		if (u.getClave() != null) {
			usu.setClave(u.getClave());
		}
		if (u.getCorreo() != null) {
			usu.setCorreo(u.getCorreo());
		}

		return usuarioService.update(usu);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return usuarioService.delete(id);
	}

}
