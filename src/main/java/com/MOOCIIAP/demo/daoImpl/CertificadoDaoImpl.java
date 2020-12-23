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

import com.MOOCIIAP.demo.dao.ICertificadoDao;
import com.MOOCIIAP.demo.models.entity.Certificado;

import oracle.jdbc.internal.OracleTypes;

@Component
public class CertificadoDaoImpl implements ICertificadoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Certificado c) {
		return  jdbcTemplate.update("CALL PKG_CERTIFICADO.SP_CREATE_CERTIFICADO(?)",
				c.getId_inscripcion_fk()
				);
	}
	
	@Override
	public int update(Certificado c) {
		return  jdbcTemplate.update("CALL PKG_CERTIFICADO.SP_UPDATE_CERTIFICADO(?,?)",
				c.getCodigo(),
				c.getId_inscripcion_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_CERTIFICADO.SP_DELETE_CERTIFICADO(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_CERTIFICADO") //nombre del paquete
				.withProcedureName("SP_READ_CERTIFICADO") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CERTIFICADOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_COD", OracleTypes.VARCHAR));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_COD", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CERTIFICADO") //nombre del paquete
				.withProcedureName("SP_LISTAR_CERTIFICADOS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CERTIFICADOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
}
