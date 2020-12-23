package com.MOOCIIAP.demo.services;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Categoria;

public interface CategoriaService {
	int create(Categoria c);
	int update(Categoria c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
