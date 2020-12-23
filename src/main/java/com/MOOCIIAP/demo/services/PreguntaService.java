package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Pregunta;

public interface PreguntaService {
	int create(Pregunta p);
	int update(Pregunta p);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByIdRecAp(int id);
	Map<String, Object> readAll();
}
