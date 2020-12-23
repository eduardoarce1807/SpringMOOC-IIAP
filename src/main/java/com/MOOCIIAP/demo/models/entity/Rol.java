package com.MOOCIIAP.demo.models.entity;

public class Rol{

	private Integer id_rol;
	private String nombre;
	private String estado;

	public Rol(Integer id_rol, String nombre, String estado) {
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Rol() {
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
