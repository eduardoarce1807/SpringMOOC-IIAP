package com.MOOCIIAP.demo.dao;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Categoria;

public interface ICategoriaDao {
	int create(Categoria c);
	int update(Categoria c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
