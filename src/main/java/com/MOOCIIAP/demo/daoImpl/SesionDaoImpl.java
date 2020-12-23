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

import com.MOOCIIAP.demo.dao.ISesionDao;
import com.MOOCIIAP.demo.models.entity.Sesion;

import oracle.jdbc.internal.OracleTypes;

@Component
public class SesionDaoImpl implements ISesionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Sesion s) {
		return jdbcTemplate.update("CALL PKG_SESION.SP_CREATE_SESION(?,?,?)",
				s.getTitulo(),
				s.getDescripcion(),
				s.getId_modulo_fk()
				);
	}
	@Override
	public int update(Sesion s) {
		return jdbcTemplate.update("CALL PKG_SESION.SP_CREATE_SESION(?,?,?,?)",
				s.getId_sesion(),
				s.getTitulo(),
				s.getDescripcion(),
				s.getId_modulo_fk()
				);
	}
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_SESION.SP_DELETE_SESION(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_SESION") //nombre del paquete
				.withProcedureName("SP_READ_SESION") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("SESIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_SES", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_SES", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readByCursoId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_SESION") //nombre del paquete
				.withProcedureName("SP_LISTAR_SESIONES_BY_CURSO_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("SESIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_C_ID", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_C_ID", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_SESION") //nombre del paquete
				.withProcedureName("SP_LISTAR_SESIONES") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("SESIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	@Override
	public Map<String, Object> readByModuloId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_SESION") //nombre del paquete
				.withProcedureName("SP_LISTAR_SESIONES_BY_MODULO_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("SESIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_MOD", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_MOD", id);
			
			return simpleJdbcCall.execute(in);
	}
	
}
