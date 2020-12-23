package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IPreguntaDao;
import com.MOOCIIAP.demo.models.entity.Pregunta;
import com.MOOCIIAP.demo.services.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private IPreguntaDao preguntaDao;

	@Override
	public int create(Pregunta p) {
		return preguntaDao.create(p);
	}

	@Override
	public int update(Pregunta p) {
		return preguntaDao.update(p);
	}

	@Override
	public int delete(int id) {
		return preguntaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return preguntaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return preguntaDao.readAll();
	}

	@Override
	public Map<String, Object> readByIdRecAp(int id) {
		return preguntaDao.readByIdRecAp(id);
	}
	
}
