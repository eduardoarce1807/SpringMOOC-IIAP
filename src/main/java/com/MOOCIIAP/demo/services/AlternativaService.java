package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Alternativa;

public interface AlternativaService {
	int create(Alternativa a);
	int update(Alternativa a);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByIdPregunta(int id);
	Map<String, Object> readByIdRecAp(int id);
	Map<String, Object> readAll();
}
