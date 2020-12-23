package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IRegistroDao;
import com.MOOCIIAP.demo.models.entity.Registro;
import com.MOOCIIAP.demo.services.RegistroService;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private IRegistroDao registroDao;

	@Override
	public int create(Registro r) {
		return registroDao.create(r);
	}

	@Override
	public int update(Registro r) {
		return registroDao.update(r);
	}

	@Override
	public int delete(int id) {
		return registroDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return registroDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return registroDao.readAll();
	}
	
}
