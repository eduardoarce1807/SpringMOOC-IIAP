package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Valoracion;

public interface ValoracionService {
	int create(Valoracion v);
	int update(Valoracion v);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
