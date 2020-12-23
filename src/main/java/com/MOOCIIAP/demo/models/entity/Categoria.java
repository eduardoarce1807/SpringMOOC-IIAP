package com.MOOCIIAP.demo.models.entity;

public class Categoria {

	private Integer id_categoria;
	private String nombre;
	private String estado;
	
	public Categoria(Integer id_categoria, String nombre, String estado) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Categoria() {
	}
	
	public Integer getId_categoria() {
		return id_categoria;
	}
	
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
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
