package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IUsuarioDao;
import com.MOOCIIAP.demo.models.entity.Usuario;
import com.MOOCIIAP.demo.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public int create(Usuario u) {
		return usuarioDao.create(u);
	}

	@Override
	public int update(Usuario u) {
		return usuarioDao.update(u);
	}

	@Override
	public int delete(int id) {
		return usuarioDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return usuarioDao.read(id);
	}
	
	@Override
	public Map<String, Object> readByDni(String dni) {
		return usuarioDao.readByDni(dni);
	}
	
	@Override
	public Map<String, Object> readIByCursoId(int id) {
		return usuarioDao.readIByCursoId(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return usuarioDao.readAll();
	}

	@Override
	public Map<String, Object> readByUsuario(String usuario) {
		return usuarioDao.readByUsuario(usuario);
	}

	@Override
	public int createR(Usuario u, int rol_id) {
		return usuarioDao.createR(u, rol_id);
	}
	
}
