package com.MOOCIIAP.demo.dao;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Registro;

public interface IRegistroDao {
	int create(Registro r);
	int update(Registro r);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
