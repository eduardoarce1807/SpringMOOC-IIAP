package com.MOOCIIAP.demo.dao;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Certificado;

public interface ICertificadoDao {
	int create(Certificado c);
	int update(Certificado c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
