package com.MOOCIIAP.demo.daoImpl;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.MOOCIIAP.demo.dao.ICategoriaDao;
import com.MOOCIIAP.demo.models.entity.Categoria;

import oracle.jdbc.internal.OracleTypes;
@Component
public class CategoriaDaoImpl implements ICategoriaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Categoria c) {
		return  jdbcTemplate.update("CALL PKG_CATEGORIA.SP_CREATE_CATEGORIA(?)", c.getNombre());
	}

	@Override
	public int update(Categoria c) {
		return  jdbcTemplate.update("CALL PKG_CATEGORIA.SP_UPDATE_CATEGORIA(?,?)", c.getId_categoria(),c.getNombre());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_CATEGORIA.SP_DELETE_CATEGORIA(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
			.withCatalogName("PKG_CATEGORIA") //nombre del paquete
			.withProcedureName("SP_READ_CATEGORIA") //nombre del procedimiento
			.declareParameters(new SqlOutParameter("CATEGORIAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_CAT", OracleTypes.NUMBER));
			SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CAT", id);
		
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CATEGORIA") //nombre del paquete
				.withProcedureName("SP_LISTAR_CATEGORIAS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CATEGORIAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

}
