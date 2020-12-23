package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Rubrica;

public interface RubricaService {
	int create(Rubrica r);
	int update(Rubrica r);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
