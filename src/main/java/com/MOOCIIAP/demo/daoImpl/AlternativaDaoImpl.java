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

import com.MOOCIIAP.demo.dao.IAlternativaDao;
import com.MOOCIIAP.demo.models.entity.Alternativa;

import oracle.jdbc.internal.OracleTypes;

@Component
public class AlternativaDaoImpl implements IAlternativaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Alternativa a) {
		return  jdbcTemplate.update("CALL PKG_ALTERNATIVA.SP_CREATE_ALTERNATIVA(?,?,?)",
				a.getNombre(),
				a.getCorrecta(),
				a.getId_pregunta_fk()
				);
	}
	
	@Override
	public int update(Alternativa a) {
		return  jdbcTemplate.update("CALL PKG_ALTERNATIVA.SP_UPDATE_ALTERNATIVA(?,?,?,?)",
				a.getId_alternativa(),
				a.getNombre(),
				a.getCorrecta(),
				a.getId_pregunta_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_ALTERNATIVA.SP_DELETE_ALTERNATIVA(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_ALTERNATIVA") //nombre del paquete
				.withProcedureName("SP_READ_ALTERNATIVA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ALTERNATIVAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_ALT", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_ALT", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_ALTERNATIVA") //nombre del paquete
				.withProcedureName("SP_LISTAR_ALTERNATIVAS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ALTERNATIVAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readByIdPregunta(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_ALTERNATIVA") //nombre del paquete
				.withProcedureName("SP_READ_ALTERNATIVAS_BY_ID_PREGUNTA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ALTERNATIVAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_PREG", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_PREG", id);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readByIdRecAp(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_ALTERNATIVA") //nombre del paquete
				.withProcedureName("SP_READ_ALTERNATIVAS_BY_ID_REC_AP") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ALTERNATIVAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_REC_AP", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_REC_AP", id);
			
			return simpleJdbcCall.execute(in);
	}
	
}
