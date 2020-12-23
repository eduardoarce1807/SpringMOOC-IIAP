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

import com.MOOCIIAP.demo.dao.IRegistroDao;
import com.MOOCIIAP.demo.models.entity.Registro;

import oracle.jdbc.internal.OracleTypes;

@Component
public class RegistroDaoImpl implements IRegistroDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Registro r) {
		return  jdbcTemplate.update("CALL PKG_REGISTRO.SP_CREATE_REGISTRO(?,?,?,?)",
				r.getNota(),
				r.getAprobado(),
				r.getId_rubrica_fk(),
				r.getId_inscripcion_fk()
				);
	}
	
	@Override
	public int update(Registro r) {
		return  jdbcTemplate.update("CALL PKG_REGISTRO.SP_UPDATE_REGISTRO(?,?,?,?,?)",
				r.getId_registro(),
				r.getNota(),
				r.getAprobado(),
				r.getId_rubrica_fk(),
				r.getId_inscripcion_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_REGISTRO.SP_DELETE_REGISTRO(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_REGISTRO") //nombre del paquete
				.withProcedureName("SP_READ_REGISTRO") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("REGISTROS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_REG", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_REG", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_REGISTRO") //nombre del paquete
				.withProcedureName("SP_LISTAR_REGISTROS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("REGISTROS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	
}
