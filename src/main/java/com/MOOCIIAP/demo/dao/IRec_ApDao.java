package com.MOOCIIAP.demo.dao;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Rec_Ap;

public interface IRec_ApDao {
	int create(Rec_Ap r_a);
	int update(Rec_Ap r_a);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readBySesionId(int id);
	Map<String, Object> readByCursoId(int id);
	Map<String, Object> readAll();
}
