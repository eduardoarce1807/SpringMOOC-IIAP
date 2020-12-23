package com.MOOCIIAP.demo.models.entity;

public class Usu_Cur {

	private Integer id_usu_cur;
	private String estado;
	private Integer id_curso_fk;
	private Integer id_usuario_fk;
	
	public Usu_Cur(Integer id_usu_cur, String estado, Integer id_curso_fk, Integer id_usuario_fk) {
		this.id_usu_cur = id_usu_cur;
		this.estado = estado;
		this.id_curso_fk = id_curso_fk;
		this.id_usuario_fk = id_usuario_fk;
	}
	
	public Usu_Cur() {
	}

	public Integer getId_usu_cur() {
		return id_usu_cur;
	}

	public void setId_usu_cur(Integer id_usu_cur) {
		this.id_usu_cur = id_usu_cur;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_curso_fk() {
		return id_curso_fk;
	}

	public void setId_curso_fk(Integer id_curso_fk) {
		this.id_curso_fk = id_curso_fk;
	}

	public Integer getId_usuario_fk() {
		return id_usuario_fk;
	}

	public void setId_usuario_fk(Integer id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}
	
}
