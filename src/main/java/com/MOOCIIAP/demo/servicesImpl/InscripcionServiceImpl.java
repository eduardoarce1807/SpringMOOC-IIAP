package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IInscripcionDao;
import com.MOOCIIAP.demo.models.entity.Inscripcion;
import com.MOOCIIAP.demo.services.InscripcionService;

@Service
public class InscripcionServiceImpl implements InscripcionService {

	@Autowired
	private IInscripcionDao inscripcionDao;

	@Override
	public int create(Inscripcion i) {
		return inscripcionDao.create(i);
	}

	@Override
	public int update(Inscripcion i) {
		return inscripcionDao.update(i);
	}

	@Override
	public int delete(int id) {
		return inscripcionDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return inscripcionDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return inscripcionDao.readAll();
	}

	@Override
	public Map<String, Object> readByIdCur(int id) {
		return inscripcionDao.readByIdCur(id);
	}

	@Override
	public Map<String, Object> readByIdCurIdUsu(int idC, int idU) {
		return inscripcionDao.readByIdCurIdUsu(idC, idU);
	}

	@Override
	public Map<String, Object> readByIdUsu(int id) {
		return inscripcionDao.readByIdCur(id);
	}
	
}
