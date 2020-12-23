package com.MOOCIIAP.demo.dao;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Rol;

public interface IRolDao {
	int create(Rol r);
	int update(Rol r);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}
