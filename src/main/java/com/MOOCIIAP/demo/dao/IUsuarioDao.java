package com.MOOCIIAP.demo.dao;

import java.util.Map;
import com.MOOCIIAP.demo.models.entity.Usuario;

public interface IUsuarioDao {
	int create(Usuario u);
	int createR(Usuario u, int rol_id);
	int update(Usuario u);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readByUsuario(String usuario);
	Map<String, Object> readByDni(String dni);
	Map<String, Object> readIByCursoId(int id);
	Map<String, Object> readAll();
}
