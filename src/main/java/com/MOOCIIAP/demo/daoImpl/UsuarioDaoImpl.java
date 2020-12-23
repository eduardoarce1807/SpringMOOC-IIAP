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

import com.MOOCIIAP.demo.dao.IUsuarioDao;
import com.MOOCIIAP.demo.models.entity.Usuario;

import oracle.jdbc.internal.OracleTypes;

@Component
public class UsuarioDaoImpl implements IUsuarioDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Usuario u) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = u.getFecha_nacimiento();

        Date date = null;
        try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(date);
        System.out.println(formatter.format(date));
        
		
		return  jdbcTemplate.update("CALL PKG_USUARIO.SP_CREATE_USUARIO(?,?,?,?,?,?,?,?,?,?)",
				u.getNombres(),
				u.getAp_paterno(),
				u.getAp_materno(),
				u.getDescripcion(),
				u.getDni(),
				u.getCorreo(),
				date,
				u.getSexo(),
				u.getUsuario(),
				u.getClave()
				);
	}
	
	@Override
	public int update(Usuario u) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = u.getFecha_nacimiento();

        Date date = null;
        try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  jdbcTemplate.update("CALL PKG_USUARIO.SP_UPDATE_USUARIO(?,?,?,?,?,?,?,?,?,?,?)",
				u.getId_usuario(),
				u.getNombres(),
				u.getAp_paterno(),
				u.getAp_materno(),
				u.getDescripcion(),
				u.getDni(),
				u.getCorreo(),
				date,
				u.getSexo(),
				u.getUsuario(),
				u.getClave()
				);
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("CALL PKG_USUARIO.SP_DELETE_USUARIO(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_USUARIO") //nombre del paquete
				.withProcedureName("SP_READ_USUARIO") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USUARIOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_U", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_U", id);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readByDni(String dni) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_USUARIO") //nombre del paquete
				.withProcedureName("SP_READ_USUARIO_BY_DNI") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USUARIOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_DNI", OracleTypes.VARCHAR));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_DNI", dni);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readIByCursoId(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_USUARIO") //nombre del paquete
				.withProcedureName("SP_READ_USUARIO_I_BY_CURSO_ID") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USUARIOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_ID_CUR", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_ID_CUR", id);
			
			return simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_USUARIO") //nombre del paquete
				.withProcedureName("SP_LISTAR_USUARIOS") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USUARIOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
		
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readByUsuario(String usuario) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("PKG_USUARIO") //nombre del paquete
				.withProcedureName("SP_READ_USUARIO_BY_USU") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("USUARIOS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("P_USU", OracleTypes.VARCHAR));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_USU", usuario);
			
			return simpleJdbcCall.execute(in);
	}

	@Override
	public int createR(Usuario u, int rol_id) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = u.getFecha_nacimiento();

        Date date = null;
        try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(date);
        System.out.println(formatter.format(date));
        
		
		return  jdbcTemplate.update("CALL PKG_USUARIO.SP_CREATE_USUARIO_R(?,?,?,?,?,?,?,?,?,?,?)",
				u.getNombres(),
				u.getAp_paterno(),
				u.getAp_materno(),
				u.getDescripcion(),
				u.getDni(),
				u.getCorreo(),
				date,
				u.getSexo(),
				u.getUsuario(),
				u.getClave(),
				rol_id
				);
	}

}
