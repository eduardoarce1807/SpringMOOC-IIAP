package com.MOOCIIAP.demo.dao;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Valoracion;

public interface IValoracionDao {
	int create(Valoracion v);
	int update(Valoracion v);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
