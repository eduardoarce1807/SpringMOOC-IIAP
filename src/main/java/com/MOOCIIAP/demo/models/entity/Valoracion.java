package com.MOOCIIAP.demo.models.entity;

public class Valoracion {

	private Integer id_valoracion;
	private Integer n_estrellas;
	private String comentario;
	private String estado;
	private Integer id_usuario_fk;
	private Integer id_curso_fk;
	
	public Valoracion(Integer id_valoracion, Integer n_estrellas, String comentario, String estado,
			Integer id_usuario_fk, Integer id_curso_fk) {
		this.id_valoracion = id_valoracion;
		this.n_estrellas = n_estrellas;
		this.comentario = comentario;
		this.estado = estado;
		this.id_usuario_fk = id_usuario_fk;
		this.id_curso_fk = id_curso_fk;
	}
	
	public Valoracion() {
	}

	public Integer getId_valoracion() {
		return id_valoracion;
	}

	public void setId_valoracion(Integer id_valoracion) {
		this.id_valoracion = id_valoracion;
	}

	public Integer getN_estrellas() {
		return n_estrellas;
	}

	public void setN_estrellas(Integer n_estrellas) {
		this.n_estrellas = n_estrellas;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_usuario_fk() {
		return id_usuario_fk;
	}

	public void setId_usuario_fk(Integer id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}

	public Integer getId_curso_fk() {
		return id_curso_fk;
	}

	public void setId_curso_fk(Integer id_curso_fk) {
		this.id_curso_fk = id_curso_fk;
	}
	
}
