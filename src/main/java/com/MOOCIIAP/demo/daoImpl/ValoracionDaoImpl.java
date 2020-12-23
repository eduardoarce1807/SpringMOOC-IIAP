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

import com.MOOCIIAP.demo.dao.IValoracionDao;
import com.MOOCIIAP.demo.models.entity.Valoracion;

import oracle.jdbc.internal.OracleTypes;

@Component
public class ValoracionDaoImpl implements IValoracionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Valoracion v) {
		return  jdbcTemplate.update("CALL PKG_VALORACION.SP_CREATE_VALORACION(?,?,?,?)",
				v.getN_estrellas(),
				v.getComentario(),
				v.getId_usuario_fk(),
				v.getId_curso_fk()
				);
	}
	
	@Override
	public int update(Valoracion v) {
		return  jdbcTemplate.update("CALL PKG_VALORACION.SP_UPDATE_VALORACION(?,?,?,?,?)",
				v.getId_valoracion(),
				v.getN_estrellas(),
				v.getComentario(),
				v.getId_usuario_fk(),
				v.getId_curso_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_VALORACION.SP_DELETE_VALORACION(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_VALORACION") //nombre del paquete
				.withProcedureName("SP_READ_VALORACION") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("VALORACIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_VALO", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID-VALO", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_VALORACION") //nombre del paquete
				.withProcedureName("SP_LISTAR_VALORACIONES") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("VALORACIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
}
