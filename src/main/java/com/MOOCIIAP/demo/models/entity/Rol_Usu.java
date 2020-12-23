package com.MOOCIIAP.demo.models.entity;

public class Rol_Usu {

	private Integer id_rol_usu;
	private String estado;
	private Integer id_rol_fk;
	private Integer id_usuario_fk;
	
	public Rol_Usu(Integer id_rol_usu, String estado, Integer id_rol_fk, Integer id_usuario_fk) {
		this.id_rol_usu = id_rol_usu;
		this.estado = estado;
		this.id_rol_fk = id_rol_fk;
		this.id_usuario_fk = id_usuario_fk;
	}

	public Rol_Usu() {
	}

	public Integer getId_rol_usu() {
		return id_rol_usu;
	}

	public void setId_rol_usu(Integer id_rol_usu) {
		this.id_rol_usu = id_rol_usu;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_rol_fk() {
		return id_rol_fk;
	}

	public void setId_rol_fk(Integer id_rol_fk) {
		this.id_rol_fk = id_rol_fk;
	}

	public Integer getId_usuario_fk() {
		return id_usuario_fk;
	}

	public void setId_usuario_fk(Integer id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}
	
}
