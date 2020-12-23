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

import com.MOOCIIAP.demo.dao.IUsu_CurDao;
import com.MOOCIIAP.demo.models.entity.Usu_Cur;

import oracle.jdbc.internal.OracleTypes;

@Component
public class Usu_CurDaoImpl implements IUsu_CurDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Usu_Cur u_c) {
		return  jdbcTemplate.update("CALL PKG_USU_CUR.SP_CREATE_USU_CUR(?,?)",
				u_c.getId_curso_fk(),
				u_c.getId_usuario_fk()
				);
	}

	@Override
	public int update(Usu_Cur u_c) {
		return  jdbcTemplate.update("CALL PKG_USU_CUR.SP_UPDATE_USU_CUR(?,?,?)",
				u_c.getId_usu_cur(),
				u_c.getId_curso_fk(),
				u_c.getId_usuario_fk()
				);
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_USU_CUR.SP_DELETE_USU_CUR(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_USU_CUR") //nombre del paquete
				.withProcedureName("SP_READ_USU_CUR") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USU_CUR", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_USU_CUR", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_USU_CUR", id);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readByUsuId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_USU_CUR") //nombre del paquete
				.withProcedureName("SP_READ_USU_CUR_BY_USU_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USU_CUR", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_USU", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_USU", id);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readByCurId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_USU_CUR") //nombre del paquete
				.withProcedureName("SP_READ_USU_CUR_BY_CUR_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USU_CUR", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_CUR", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CUR", id);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_USU_CUR") //nombre del paquete
				.withProcedureName("SP_LISTAR_USU_CUR") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USU_CUR", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

	
	
}
