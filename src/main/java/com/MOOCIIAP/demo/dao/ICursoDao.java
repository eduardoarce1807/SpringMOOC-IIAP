package com.MOOCIIAP.demo.dao;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Curso;

public interface ICursoDao {
	int create(Curso c);
	int update(Curso c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByUrl(String url);
	Map<String, Object> readByIdUsuario(int id);
	Map<String, Object> readAll();
}
