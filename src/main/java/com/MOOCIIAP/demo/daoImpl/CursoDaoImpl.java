package com.MOOCIIAP.demo.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.MOOCIIAP.demo.dao.ICursoDao;
import com.MOOCIIAP.demo.models.entity.Curso;

import oracle.jdbc.internal.OracleTypes;

@Component
public class CursoDaoImpl implements ICursoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Curso c) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = c.getFecha_creacion();

        Date date = null;
        try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(date);
        System.out.println(formatter.format(date));
		
		return  jdbcTemplate.update("CALL PKG_CURSO.SP_CREATE_CURSO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				c.getTitulo(),
				c.getSubtitulo(),
				c.getPrecio(),
				c.getRuta_img(),
				c.getRuta_vid(),
				c.getUrl(),
				c.getDuracion(),
				c.getCertificacion_tit(),
				c.getCertificadora(),
				c.getCertificadora_2(),
				c.getObjetivo(),
				c.getPerfil_participante(),
				c.getMetodologia(),
				c.getCompetencias(),
				date,
				c.getId_categoria_fk()
				);
	}
	@Override
	public int update(Curso c) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = c.getFecha_creacion();

        Date date = null;
        try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(date);
        System.out.println(formatter.format(date));
		
		return  jdbcTemplate.update("CALL PKG_CURSO.SP_UPDATE_CURSO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				c.getId_curso(),
				c.getTitulo(),
				c.getSubtitulo(),
				c.getPrecio(),
				c.getRuta_img(),
				c.getRuta_vid(),
				c.getUrl(),
				c.getDuracion(),
				c.getCertificacion_tit(),
				c.getCertificadora(),
				c.getCertificadora_2(),
				c.getObjetivo(),
				c.getPerfil_participante(),
				c.getMetodologia(),
				c.getCompetencias(),
				date,
				c.getId_categoria_fk()
				);
	}
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_CURSO.SP_DELETE_CURSO(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_CURSO") //nombre del paquete
				.withProcedureName("SP_READ_CURSO") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_CUR", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CUR", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readByUrl(String url) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_CURSO") //nombre del paquete
				.withProcedureName("SP_READ_CURSO_BY_URL") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_URL", OracleTypes.VARCHAR));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_URL", url);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CURSO") //nombre del paquete
				.withProcedureName("SP_LISTAR_CURSOS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}
	@Override
	public Map<String, Object> readByIdUsuario(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_CURSO") //nombre del paquete
				.withProcedureName("SP_READ_CURSOS_BY_ID_USUARIO") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_USU", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_USU", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	
}
