package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IRolDao;
import com.MOOCIIAP.demo.models.entity.Rol;
import com.MOOCIIAP.demo.services.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	IRolDao rolDao;

	@Override
	public int create(Rol r) {
		return rolDao.create(r);
	}

	@Override
	public int update(Rol r) {
		return rolDao.update(r);
	}

	@Override
	public int delete(int id) {
		return rolDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return rolDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return rolDao.readAll();
	}
	
}
