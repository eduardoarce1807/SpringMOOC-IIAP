package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IValoracionDao;
import com.MOOCIIAP.demo.models.entity.Valoracion;
import com.MOOCIIAP.demo.services.ValoracionService;

@Service
public class ValoracionServiceImpl implements ValoracionService {

	@Autowired
	private IValoracionDao valoracionDao;

	@Override
	public int create(Valoracion v) {
		return valoracionDao.create(v);
	}

	@Override
	public int update(Valoracion v) {
		return valoracionDao.update(v);
	}

	@Override
	public int delete(int id) {
		return valoracionDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return valoracionDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return valoracionDao.readAll();
	}
	
}
