package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.ISesionDao;
import com.MOOCIIAP.demo.models.entity.Sesion;
import com.MOOCIIAP.demo.services.SesionService;

@Service
public class SesionServiceImpl implements SesionService {
	
	@Autowired
	private ISesionDao sesionDao;

	@Override
	public int create(Sesion s) {
		return sesionDao.create(s);
	}

	@Override
	public int update(Sesion s) {
		return sesionDao.update(s);
	}

	@Override
	public int delete(int id) {
		return sesionDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return sesionDao.read(id);
	}
	
	@Override
	public Map<String, Object> readByCursoId(int id) {
		return sesionDao.readByCursoId(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return sesionDao.readAll();
	}

	@Override
	public Map<String, Object> readByModuloId(int id) {
		return sesionDao.readByModuloId(id);
	}

}
