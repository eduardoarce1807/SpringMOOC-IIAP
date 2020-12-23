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

import com.MOOCIIAP.demo.dao.IRol_UsuDao;
import com.MOOCIIAP.demo.models.entity.Rol_Usu;

import oracle.jdbc.internal.OracleTypes;

@Component
public class Rol_UsuDaoImpl implements IRol_UsuDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Rol_Usu r_u) {
		return  jdbcTemplate.update("CALL PKG_ROL_USU.SP_CREATE_ROL_USU(?,?)", r_u.getId_rol_fk(), r_u.getId_usuario_fk());
	}
	
	@Override
	public int update(Rol_Usu r_u) {
		return  jdbcTemplate.update("CALL PKG_ROL_USU.SP_UPDATE_ROL_USU(?,?,?)", r_u.getId_rol_usu(), r_u.getId_rol_fk(), r_u.getId_usuario_fk());
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_ROL_USU.SP_DELETE_ROL_USU(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_ROL_USU") //nombre del paquete
				.withProcedureName("SP_READ_ROL_USU") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ROLES_USU", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_ROL_USU", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_ROL_USU", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readUsu(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_ROL_USU") //nombre del paquete
				.withProcedureName("SP_READ_ROL_USU_ID_USU") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ROLES_USU", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_USU", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_USU", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_ROL_USU") //nombre del paquete
				.withProcedureName("SP_LISTAR_ROLES_USU") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("ROLES_USU", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
}
