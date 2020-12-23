package com.MOOCIIAP.demo.dao;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Ctrl_Vista;

public interface ICtrl_VistaDao {
	int create(Ctrl_Vista c_v);
	int update(Ctrl_Vista c_v);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByIdRecAp(int id);
	Map<String, Object> readAll();
}
