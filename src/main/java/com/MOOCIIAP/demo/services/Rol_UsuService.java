package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Rol_Usu;

public interface Rol_UsuService {
	int create(Rol_Usu r_u);
	int update(Rol_Usu r_u);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readUsu(int id);
	Map<String, Object> readAll();
}
