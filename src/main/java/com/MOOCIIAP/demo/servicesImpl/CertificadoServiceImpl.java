package com.MOOCIIAP.demo.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MOOCIIAP.demo.dao.ICertificadoDao;
import com.MOOCIIAP.demo.models.entity.Certificado;
import com.MOOCIIAP.demo.services.CertificadoService;

@Service
public class CertificadoServiceImpl implements CertificadoService {

	@Autowired
	private ICertificadoDao certificadoDao;

	@Override
	public int create(Certificado c) {
		return certificadoDao.create(c);
	}

	@Override
	public int update(Certificado c) {
		return certificadoDao.update(c);
	}

	@Override
	public int delete(int id) {
		return certificadoDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return certificadoDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return certificadoDao.readAll();
	}
	
}
