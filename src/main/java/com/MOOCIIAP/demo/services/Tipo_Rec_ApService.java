package com.MOOCIIAP.demo.services;

import java.util.Map;

import com.MOOCIIAP.demo.models.entity.Tipo_Rec_Ap;

public interface Tipo_Rec_ApService {
	int create(Tipo_Rec_Ap t_r_a);
	int update(Tipo_Rec_Ap t_r_a);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
