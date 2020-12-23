package com.MOOCIIAP.demo.dao;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Rol_Usu;

public interface IRol_UsuDao {
	int create(Rol_Usu r_u);
	int update(Rol_Usu r_u);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readUsu(int id);
	Map<String, Object> readAll();
}
