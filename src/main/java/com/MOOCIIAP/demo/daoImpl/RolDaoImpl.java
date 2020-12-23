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

import com.MOOCIIAP.demo.dao.IRolDao;
import com.MOOCIIAP.demo.models.entity.Rol;

import oracle.jdbc.internal.OracleTypes;

@Component
public class RolDaoImpl implements IRolDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Rol r) {
		return  jdbcTemplate.update("CALL PKG_ROL.SP_CREATE_ROL(?)", r.getNombre());
	}

	@Override
	public int update(Rol r) {
		return  jdbcTemplate.update("CALL PKG_ROL.SP_UPDATE_ROL(?,?)", r.getId_rol(), r.getNombre());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_ROL.SP_DELETE_ROL(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_ROL") //nombre del paquete
				.withProcedureName("SP_READ_ROL") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ROLES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_ROL", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_ROL", id);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_ROL") //nombre del paquete
				.withProcedureName("SP_LISTAR_ROLES") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ROLES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

}
