package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Respuesta;

public interface RespuestaService {
	int create(Respuesta r);
	int update(Respuesta r);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
