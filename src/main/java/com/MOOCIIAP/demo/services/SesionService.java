package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Sesion;

public interface SesionService {
	int create(Sesion s);
	int update(Sesion s);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByModuloId(int id);
	Map<String, Object> readByCursoId(int id);
	Map<String, Object> readAll();
}
