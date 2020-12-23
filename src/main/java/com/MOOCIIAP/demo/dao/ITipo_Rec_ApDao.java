package com.MOOCIIAP.demo.dao;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Tipo_Rec_Ap;

public interface ITipo_Rec_ApDao {
	int create(Tipo_Rec_Ap t_r_a);
	int update(Tipo_Rec_Ap t_r_a);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
