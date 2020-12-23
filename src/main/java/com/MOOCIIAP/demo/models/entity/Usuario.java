package com.MOOCIIAP.demo.models.entity;

public class Usuario {

	private Integer id_usuario;
	private String nombres;
	private String ap_paterno;
	private String ap_materno;
	private String descripcion;
	private String dni;
	private String correo;
	private String fecha_nacimiento;
	private String sexo;
	private String usuario;
	private String clave;
	private String estado;
	
	public Usuario() {
	}
	
	public Usuario(Integer id_usuario, String nombres, String ap_paterno, String ap_materno, String descripcion,
			String dni, String correo, String fecha_nacimiento, String sexo, String usuario, String clave,
			String estado) {
		this.id_usuario = id_usuario;
		this.nombres = nombres;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.descripcion = descripcion;
		this.dni = dni;
		this.correo = correo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.usuario = usuario;
		this.clave = clave;
		this.estado = estado;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
