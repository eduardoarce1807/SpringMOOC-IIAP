package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IRol_UsuDao;
import com.MOOCIIAP.demo.models.entity.Rol_Usu;
import com.MOOCIIAP.demo.services.Rol_UsuService;

@Service
public class Rol_UsuServiceImpl implements Rol_UsuService {

	@Autowired
	private IRol_UsuDao rol_usuDao;

	@Override
	public int create(Rol_Usu r_u) {
		return rol_usuDao.create(r_u);
	}

	@Override
	public int update(Rol_Usu r_u) {
		return rol_usuDao.update(r_u);
	}

	@Override
	public int delete(int id) {
		return rol_usuDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return rol_usuDao.read(id);
	}
	
	@Override
	public Map<String, Object> readUsu(int id) {
		return rol_usuDao.readUsu(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return rol_usuDao.readAll();
	}
	
}
