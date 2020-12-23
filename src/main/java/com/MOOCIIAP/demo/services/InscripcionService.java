package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Inscripcion;

public interface InscripcionService {
	int create(Inscripcion i);
	int update(Inscripcion i);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByIdCur(int id);
	Map<String, Object> readByIdUsu(int id);
	Map<String, Object> readByIdCurIdUsu(int idC, int idU);
	Map<String, Object> readAll();
}
