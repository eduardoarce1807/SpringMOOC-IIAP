package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IRec_ApDao;
import com.MOOCIIAP.demo.models.entity.Rec_Ap;
import com.MOOCIIAP.demo.services.Rec_ApService;

@Service
public class Rec_ApServiceImpl implements Rec_ApService {
	
	@Autowired
	private IRec_ApDao rec_apDao;

	@Override
	public int create(Rec_Ap r_a) {
		return rec_apDao.create(r_a);
	}

	@Override
	public int update(Rec_Ap r_a) {
		return rec_apDao.update(r_a);
	}

	@Override
	public int delete(int id) {
		return rec_apDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return rec_apDao.read(id);
	}
	
	@Override
	public Map<String, Object> readBySesionId(int id) {
		return rec_apDao.readBySesionId(id);
	}
	
	@Override
	public Map<String, Object> readByCursoId(int id) {
		return rec_apDao.readByCursoId(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return rec_apDao.readAll();
	}

}
