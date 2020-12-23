package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.IUsu_CurDao;
import com.MOOCIIAP.demo.models.entity.Usu_Cur;
import com.MOOCIIAP.demo.services.Usu_CurService;

@Service
public class Usu_CurServiceImpl implements Usu_CurService {

	@Autowired
	private IUsu_CurDao usu_curDao;

	@Override
	public int create(Usu_Cur u_c) {
		return usu_curDao.create(u_c);
	}

	@Override
	public int update(Usu_Cur u_c) {
		return usu_curDao.update(u_c);
	}

	@Override
	public int delete(int id) {
		return usu_curDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return usu_curDao.read(id);
	}

	@Override
	public Map<String, Object> readByUsuId(int id) {
		return usu_curDao.readByUsuId(id);
	}

	@Override
	public Map<String, Object> readByCurId(int id) {
		return usu_curDao.readByCurId(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return usu_curDao.readAll();
	}
	
}
