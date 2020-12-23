package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Ctrl_Vista;

public interface Ctrl_VistaService {
	int create(Ctrl_Vista c_v);
	int update(Ctrl_Vista c_v);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByIdRecAp(int id);
	Map<String, Object> readAll();
}
