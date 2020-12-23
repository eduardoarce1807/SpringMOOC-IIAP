package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Certificado;

public interface CertificadoService {
	int create(Certificado c);
	int update(Certificado c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
