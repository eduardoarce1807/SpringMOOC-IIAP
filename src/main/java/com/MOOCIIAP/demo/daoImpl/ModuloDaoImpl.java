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

import com.MOOCIIAP.demo.dao.IModuloDao;
import com.MOOCIIAP.demo.models.entity.Modulo;

import oracle.jdbc.internal.OracleTypes;

@Component
public class ModuloDaoImpl implements IModuloDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Modulo m) {
		return jdbcTemplate.update("CALL PKG_MODULO.SP_CREATE_MODULO(?,?,?)",
				m.getTitulo(),
				m.getDescripcion(),
				m.getId_curso_fk()
				);
	}
	@Override
	public int update(Modulo m) {
		return jdbcTemplate.update("CALL PKG_MODULO.SP_UPDATE_MODULO(?,?,?,?)",
				m.getId_modulo(),
				m.getTitulo(),
				m.getDescripcion(),
				m.getId_curso_fk()
				);
	}
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_MODULO.SP_DELETE_MODULO(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_MODULO") //nombre del paquete
				.withProcedureName("SP_READ_MODULO") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("MODULOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_MOD", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_MOD", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readByCursoId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_MODULO") //nombre del paquete
				.withProcedureName("SP_LISTAR_MODULOS_BY_CURSO_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("MODULOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_C_ID", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_C_ID", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_MODULO") //nombre del paquete
				.withProcedureName("SP_LISTAR_MODULOS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("MODULOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
}
