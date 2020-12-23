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

import com.MOOCIIAP.demo.dao.ICtrl_VistaDao;
import com.MOOCIIAP.demo.models.entity.Ctrl_Vista;

import oracle.jdbc.internal.OracleTypes;

@Component
public class Ctrl_VistaDaoImpl implements ICtrl_VistaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Ctrl_Vista c_v) {
		return  jdbcTemplate.update("CALL PKG_CTRL_VISTA.SP_CREATE_CTRL_VISTA(?,?,?)",
				c_v.getVisto(),
				c_v.getId_inscripcion_fk(),
				c_v.getId_rec_ap_fk()
				);
	}
	
	@Override
	public int update(Ctrl_Vista c_v) {
		return  jdbcTemplate.update("CALL PKG_CTRL_VISTA.SP_UPDATE_CTRL_VISTA(?,?,?,?)",
				c_v.getId_ctrl_vista(),
				c_v.getVisto(),
				c_v.getId_inscripcion_fk(),
				c_v.getId_rec_ap_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_CTRL_VISTA.SP_DELETE_CTRL_VISTA(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_CTRL_VISTA") //nombre del paquete
				.withProcedureName("SP_READ_CTRL_VISTA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CTRL_VISTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_CTRL_VIS", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CTRL_VIS", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CTRL_VISTA") //nombre del paquete
				.withProcedureName("SP_LISTAR_CTRL_VISTAS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CTRL_VISTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readByIdRecAp(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_CTRL_VISTA") //nombre del paquete
				.withProcedureName("SP_READ_CTRL_VISTA_BY_ID_REC_AP") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CTRL_VISTAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_REC_AP", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_REC_AP", id);
			
			return simpleJdbcCall.execute(in);
	}
	
}
