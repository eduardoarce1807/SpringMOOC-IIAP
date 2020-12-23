package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IAlternativaDao;
import com.MOOCIIAP.demo.models.entity.Alternativa;
import com.MOOCIIAP.demo.services.AlternativaService;

@Service
public class AlternativaServiceImpl implements AlternativaService {

	@Autowired
	private IAlternativaDao alternativaDao;

	@Override
	public int create(Alternativa a) {
		return alternativaDao.create(a);
	}

	@Override
	public int update(Alternativa a) {
		return alternativaDao.update(a);
	}

	@Override
	public int delete(int id) {
		return alternativaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return alternativaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return alternativaDao.readAll();
	}

	@Override
	public Map<String, Object> readByIdPregunta(int id) {
		return alternativaDao.readByIdPregunta(id);
	}

	@Override
	public Map<String, Object> readByIdRecAp(int id) {
		return alternativaDao.readByIdRecAp(id);
	}
	
}
