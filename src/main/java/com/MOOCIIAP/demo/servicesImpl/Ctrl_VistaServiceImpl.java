package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.ICtrl_VistaDao;
import com.MOOCIIAP.demo.models.entity.Ctrl_Vista;
import com.MOOCIIAP.demo.services.Ctrl_VistaService;

@Service
public class Ctrl_VistaServiceImpl implements Ctrl_VistaService {

	@Autowired
	private ICtrl_VistaDao ctrl_vistaDao;

	@Override
	public int create(Ctrl_Vista c_v) {
		return ctrl_vistaDao.create(c_v);
	}

	@Override
	public int update(Ctrl_Vista c_v) {
		return ctrl_vistaDao.update(c_v);
	}

	@Override
	public int delete(int id) {
		return ctrl_vistaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return ctrl_vistaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return ctrl_vistaDao.readAll();
	}

	@Override
	public Map<String, Object> readByIdRecAp(int id) {
		return ctrl_vistaDao.readByIdRecAp(id);
	}
	
	
	
}
