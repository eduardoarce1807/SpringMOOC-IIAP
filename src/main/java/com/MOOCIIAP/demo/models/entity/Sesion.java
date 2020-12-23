package com.MOOCIIAP.demo.models.entity;

public class Sesion {

	private Integer id_sesion;
	private String titulo;
	private String descripcion;
	private String estado;
	private Integer id_modulo_fk;
	
	public Sesion(Integer id_sesion, String titulo, String descripcion, String estado, Integer id_modulo_fk) {
		this.id_sesion = id_sesion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.id_modulo_fk = id_modulo_fk;
	}

	public Sesion() {
	}

	public Integer getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(Integer id_sesion) {
		this.id_sesion = id_sesion;
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

	public Integer getId_modulo_fk() {
		return id_modulo_fk;
	}

	public void setId_modulo_fk(Integer id_modulo_fk) {
		this.id_modulo_fk = id_modulo_fk;
	}

}
