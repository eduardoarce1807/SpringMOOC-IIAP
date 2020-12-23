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

import com.MOOCIIAP.demo.dao.ITipo_Rec_ApDao;
import com.MOOCIIAP.demo.models.entity.Tipo_Rec_Ap;

import oracle.jdbc.internal.OracleTypes;

@Component
public class Tipo_Rec_ApDaoImpl implements ITipo_Rec_ApDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Tipo_Rec_Ap t_r_a) {
		return  jdbcTemplate.update("CALL PKG_TIPO_REC_AP.SP_CREATE_TIPO_REC_AP(?)",
				t_r_a.getNombre()
				);
	}
	@Override
	public int update(Tipo_Rec_Ap t_r_a) {
		return  jdbcTemplate.update("CALL PKG_TIPO_REC_AP.SP_UPDATE_TIPO_REC_AP(?,?)",
				t_r_a.getId_tipo_rec_ap(),
				t_r_a.getNombre()
				);
	}
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_TIPO_REC_AP.SP_DELETE_TIPO_REC_AP(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_TIPO_REC_AP") //nombre del paquete
				.withProcedureName("SP_READ_TIPO_REC_AP") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("TIPOS_REC_AP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_T_R_A", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_T_R_A", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_TIPO_REC_AP") //nombre del paquete
				.withProcedureName("SP_LISTAR_TIPOS_REC_AP") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("TIPOS_REC_AP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
}
