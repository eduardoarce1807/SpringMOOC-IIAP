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

import com.MOOCIIAP.demo.dao.IInscripcionDao;
import com.MOOCIIAP.demo.models.entity.Inscripcion;

import oracle.jdbc.internal.OracleTypes;

@Component
public class InscripcionDaoImpl implements IInscripcionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Inscripcion i) {
		return  jdbcTemplate.update("CALL PKG_INSCRIPCION.SP_CREATE_INSCRIPCION(?,?,?,?)",
				i.getNota_final(),
				i.getProgreso(),
				i.getId_curso_fk(),
				i.getId_usuario_fk()
				);
	}
	
	@Override
	public int update(Inscripcion i) {
		return  jdbcTemplate.update("CALL PKG_INSCRIPCION.SP_UPDATE_INSCRIPCION(?,?,?,?,?)",
				i.getId_inscripcion(),
				i.getNota_final(),
				i.getProgreso(),
				i.getId_curso_fk(),
				i.getId_usuario_fk()
				);
	}
	
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_INSCRIPCION.SP_DELETE_INSCRIPCION(?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_INSCRIPCION") //nombre del paquete
				.withProcedureName("SP_READ_INSCRIPCION") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("INSCRIPCIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_INS", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_INS", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_INSCRIPCION") //nombre del paquete
				.withProcedureName("SP_LISTAR_INSCRIPCIONES") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("INSCRIPCIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readByIdCur(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_INSCRIPCION") //nombre del paquete
				.withProcedureName("SP_READ_INSCRIPCIONES_BY_ID_CUR") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("INSCRIPCIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_CUR", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CUR", id);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readByIdCurIdUsu(int idC, int idU) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_INSCRIPCION") //nombre del paquete
				.withProcedureName("SP_READ_INSCRIPCION_BY_ID_CUR_ID_USU") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("INSCRIPCIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_CUR", OracleTypes.NUMBER), new SqlParameter("P_ID_USU", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CUR", idC).addValue("P_ID_USU", idU);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readByIdUsu(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_INSCRIPCION") //nombre del paquete
				.withProcedureName("SP_READ_INSCRIPCION_BY_ID_USU") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("INSCRIPCIONES", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_USU", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_USU", id);
			
			return simpleJdbcCall.execute(in);
	}
	
}
