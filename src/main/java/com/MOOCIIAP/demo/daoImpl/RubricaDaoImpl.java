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

import com.MOOCIIAP.demo.dao.IRubricaDao;
import com.MOOCIIAP.demo.models.entity.Rubrica;

import oracle.jdbc.internal.OracleTypes;

@Component
public class RubricaDaoImpl implements IRubricaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Rubrica r) {
		return  jdbcTemplate.update("CALL PKG_RUBRICA.SP_CREATE_RUBRICA(?,?,?,?)",
				r.getNombre(),
				r.getPonderado(),
				r.getId_curso_fk(),
				r.getId_modulo_fk()
				);
	}
	
	@Override
	public int update(Rubrica r) {
		return  jdbcTemplate.update("CALL PKG_RUBRICA.SP_UPDATE_RUBRICA(?,?,?,?,?)",
				r.getId_rubrica(),
				r.getNombre(),
				r.getPonderado(),
				r.getId_curso_fk(),
				r.getId_modulo_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_RUBRICA.SP_DELETE_RUBRICA(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_RUBRICA") //nombre del paquete
				.withProcedureName("SP_READ_RUBRICA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RUBRICAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_RUB", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_RUB", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_RUBRICA") //nombre del paquete
				.withProcedureName("SP_LISTAR_RUBRICAS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RUBRICAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
	
	
}
