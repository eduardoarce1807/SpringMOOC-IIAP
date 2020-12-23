package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.ICategoriaDao;
import com.MOOCIIAP.demo.models.entity.Categoria;
import com.MOOCIIAP.demo.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	public int create(Categoria c) {
		return categoriaDao.create(c);
	}

	@Override
	public int update(Categoria c) {
		return categoriaDao.update(c);
	}

	@Override
	public int delete(int id) {
		return categoriaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return categoriaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return categoriaDao.readAll();
	}
	
}
