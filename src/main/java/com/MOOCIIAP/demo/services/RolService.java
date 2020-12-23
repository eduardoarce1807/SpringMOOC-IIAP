package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Rol;

public interface RolService {
	int create(Rol r);
	int update(Rol r);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
