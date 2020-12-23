package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IModuloDao;
import com.MOOCIIAP.demo.models.entity.Modulo;
import com.MOOCIIAP.demo.services.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	private IModuloDao moduloDao;

	@Override
	public int create(Modulo m) {
		return moduloDao.create(m);
	}

	@Override
	public int update(Modulo m) {
		return moduloDao.update(m);
	}

	@Override
	public int delete(int id) {
		return moduloDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return moduloDao.read(id);
	}
	
	@Override
	public Map<String, Object> readByCursoId(int id) {
		return moduloDao.readByCursoId(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return moduloDao.readAll();
	}

	
}
