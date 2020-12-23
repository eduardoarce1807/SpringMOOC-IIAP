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

import com.MOOCIIAP.demo.dao.IPreguntaDao;
import com.MOOCIIAP.demo.models.entity.Pregunta;

import oracle.jdbc.internal.OracleTypes;

@Component
public class PreguntaDaoImpl implements IPreguntaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Pregunta p) {
		return  jdbcTemplate.update("CALL PKG_PREGUNTA.SP_CREATE_PREGUNTA(?,?)",
				p.getNombre(),
				p.getId_rec_ap_fk()
				);
	}
	
	@Override
	public int update(Pregunta p) {
		return  jdbcTemplate.update("CALL PKG_PREGUNTA.SP_UPDATE_PREGUNTA(?,?,?)",
				p.getId_pregunta(),
				p.getNombre(),
				p.getId_rec_ap_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_PREGUNTA.SP_DELETE_PREGUNTA(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_PREGUNTA") //nombre del paquete
				.withProcedureName("SP_READ_PREGUNTA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("PREGUNTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_PRE", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_PRE", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_PREGUNTA") //nombre del paquete
				.withProcedureName("SP_LISTAR_PREGUNTAS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("PREGUNTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readByIdRecAp(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_PREGUNTA") //nombre del paquete
				.withProcedureName("SP_READ_PREGUNTAS_BY_ID_REC_AP") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("PREGUNTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_REC_AP", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_REC_AP", id);
			
			return simpleJdbcCall.execute(in);
	}
	
}
