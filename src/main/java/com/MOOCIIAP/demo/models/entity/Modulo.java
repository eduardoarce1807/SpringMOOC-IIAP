package com.MOOCIIAP.demo.models.entity;

public class Modulo {

	private Integer id_modulo;
	private String titulo;
	private String descripcion;
	private String estado;
	private Integer id_curso_fk;
	
	public Modulo(Integer id_modulo, String titulo, String descripcion, String estado, Integer id_curso_fk) {
		this.id_modulo = id_modulo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.id_curso_fk = id_curso_fk;
	}

	public Modulo() {
	}

	public Integer getId_modulo() {
		return id_modulo;
	}

	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

}
