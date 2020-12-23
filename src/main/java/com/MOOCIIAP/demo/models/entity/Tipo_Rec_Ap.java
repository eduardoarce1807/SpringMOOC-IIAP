package com.MOOCIIAP.demo.models.entity;

public class Tipo_Rec_Ap {

	private Integer id_tipo_rec_ap;
	private String nombre;
	private String estado;

	public Tipo_Rec_Ap(Integer id_tipo_rec_ap, String nombre, String estado) {
		this.id_tipo_rec_ap = id_tipo_rec_ap;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Tipo_Rec_Ap() {
	}

	public Integer getId_tipo_rec_ap() {
		return id_tipo_rec_ap;
	}

	public void setId_tipo_rec_ap(Integer id_tipo_rec_ap) {
		this.id_tipo_rec_ap = id_tipo_rec_ap;
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
