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

import com.MOOCIIAP.demo.dao.IRespuestaDao;
import com.MOOCIIAP.demo.models.entity.Respuesta;

import oracle.jdbc.internal.OracleTypes;

@Component
public class RespuestaDaoImpl implements IRespuestaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Respuesta r) {
		return  jdbcTemplate.update("CALL PKG_RESPUESTA.SP_CREATE_RESPUESTA(?,?)",
				r.getId_alternativa_fk(),
				r.getId_inscripcion_fk()
				);
	}
	
	@Override
	public int update(Respuesta r) {
		return  jdbcTemplate.update("CALL PKG_RESPUESTA.SP_UPDATE_RESPUESTA(?,?,?)",
				r.getId_respuesta(),
				r.getId_alternativa_fk(),
				r.getId_inscripcion_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_RESPUESTA.SP_DELETE_RESPUESTA(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_RESPUESTA") //nombre del paquete
				.withProcedureName("SP_READ_RESPUESTA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RESPUESTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_RESP", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_RESP", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_RESPUESTA") //nombre del paquete
				.withProcedureName("SP_LISTAR_RESPUESTAS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RESPUESTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
}
