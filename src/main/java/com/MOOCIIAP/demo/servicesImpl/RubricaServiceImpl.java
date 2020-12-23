package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IRubricaDao;
import com.MOOCIIAP.demo.models.entity.Rubrica;
import com.MOOCIIAP.demo.services.RubricaService;

@Service
public class RubricaServiceImpl implements RubricaService {

	@Autowired
	private IRubricaDao rubricaDao;

	@Override
	public int create(Rubrica r) {
		return rubricaDao.create(r);
	}

	@Override
	public int update(Rubrica r) {
		return rubricaDao.update(r);
	}

	@Override
	public int delete(int id) {
		return rubricaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return rubricaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return rubricaDao.readAll();
	}
	
}
