package com.MOOCIIAP.demo.dao;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Modulo;

public interface IModuloDao {
	int create(Modulo m);
	int update(Modulo m);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByCursoId(int id);
	Map<String, Object> readAll();
}
