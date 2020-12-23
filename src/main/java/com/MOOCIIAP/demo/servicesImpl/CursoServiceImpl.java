package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.ICursoDao;
import com.MOOCIIAP.demo.models.entity.Curso;
import com.MOOCIIAP.demo.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private ICursoDao cursoDao;

	@Override
	public int create(Curso c) {
		return cursoDao.create(c);
	}

	@Override
	public int update(Curso c) {
		return cursoDao.update(c);
	}

	@Override
	public int delete(int id) {
		return cursoDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return cursoDao.read(id);
	}

	@Override
	public Map<String, Object> readByUrl(String url) {
		return cursoDao.readByUrl(url);
	}
	
	@Override
	public Map<String, Object> readAll() {
		return cursoDao.readAll();
	}

	@Override
	public Map<String, Object> readByIdUsuario(int id) {
		return cursoDao.readByIdUsuario(id);
	}
	
}
