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

import com.MOOCIIAP.demo.dao.IRec_ApDao;
import com.MOOCIIAP.demo.models.entity.Rec_Ap;

import oracle.jdbc.internal.OracleTypes;

@Component
public class Rec_ApDaoImpl implements IRec_ApDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Rec_Ap r_a) {
		return  jdbcTemplate.update("CALL PKG_REC_AP.SP_CREATE_REC_AP(?,?,?,?,?,?,?)",
				r_a.getTitulo(),
				r_a.getNota(),
				r_a.getUrl(),
				r_a.getCompletada(),
				r_a.getId_sesion_fk(),
				r_a.getId_tipo_rec_ap_fk(),
				r_a.getId_rubrica_fk()
				);
	}
	@Override
	public int update(Rec_Ap r_a) {
		return  jdbcTemplate.update("CALL PKG_REC_AP.SP_UPDATE_REC_AP(?,?,?,?,?,?,?,?)",
				r_a.getId_rec_ap(),
				r_a.getTitulo(),
				r_a.getNota(),
				r_a.getUrl(),
				r_a.getCompletada(),
				r_a.getId_sesion_fk(),
				r_a.getId_tipo_rec_ap_fk(),
				r_a.getId_rubrica_fk()
				);
	}
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_REC_AP.SP_DELETE_REC_AP(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_REC_AP") //nombre del paquete
				.withProcedureName("SP_READ_REC_AP") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RECS_AP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_R_A", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_R_A", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readBySesionId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_REC_AP") //nombre del paquete
				.withProcedureName("SP_LISTAR_RECS_AP_BY_SESION_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RECS_AP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_SES_ID", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_SES_ID", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readByCursoId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_REC_AP") //nombre del paquete
				.withProcedureName("SP_LISTAR_RECS_AP_BY_CURSO_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RECS_AP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_C_ID", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_C_ID", id);
			
			return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_REC_AP") //nombre del paquete
				.withProcedureName("SP_LISTAR_RECS_AP") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("RECS_AP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
	
}
