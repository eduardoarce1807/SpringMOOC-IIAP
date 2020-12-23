package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.ITipo_Rec_ApDao;
import com.MOOCIIAP.demo.models.entity.Tipo_Rec_Ap;
import com.MOOCIIAP.demo.services.Tipo_Rec_ApService;

@Service
public class Tipo_Rec_ApServiceImpl implements Tipo_Rec_ApService {

	@Autowired
	private ITipo_Rec_ApDao tipo_rec_apDao;

	@Override
	public int create(Tipo_Rec_Ap t_r_a) {
		return tipo_rec_apDao.create(t_r_a);
	}

	@Override
	public int update(Tipo_Rec_Ap t_r_a) {
		return tipo_rec_apDao.update(t_r_a);
	}

	@Override
	public int delete(int id) {
		return tipo_rec_apDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return tipo_rec_apDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return tipo_rec_apDao.readAll();
	}
	
}
