package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Usu_Cur;

public interface Usu_CurService {
	int create(Usu_Cur u_c);
	int update(Usu_Cur u_c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByUsuId(int id);
	Map<String, Object> readByCurId(int id);
	Map<String, Object> readAll();
}
