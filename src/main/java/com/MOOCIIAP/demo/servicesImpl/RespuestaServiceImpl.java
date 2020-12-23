package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IRespuestaDao;
import com.MOOCIIAP.demo.models.entity.Respuesta;
import com.MOOCIIAP.demo.services.RespuestaService;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	private IRespuestaDao respuestaDao;

	@Override
	public int create(Respuesta r) {
		return respuestaDao.create(r);
	}

	@Override
	public int update(Respuesta r) {
		return respuestaDao.update(r);
	}

	@Override
	public int delete(int id) {
		return respuestaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return respuestaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return respuestaDao.readAll();
	}
	
}
