package com.MOOCIIAP.demo.models.entity;

public class Pregunta {

	private Integer id_pregunta;
	private String nombre;
	private String estado;
	private Integer id_rec_ap_fk;
	
	public Pregunta(Integer id_pregunta, String nombre, String estado, Integer id_rec_ap_fk) {
		this.id_pregunta = id_pregunta;
		this.nombre = nombre;
		this.estado = estado;
		this.id_rec_ap_fk = id_rec_ap_fk;
	}

	public Pregunta() {
	}
	
	public Integer getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(Integer id_pregunta) {
		this.id_pregunta = id_pregunta;
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

	public Integer getId_rec_ap_fk() {
		return id_rec_ap_fk;
	}

	public void setId_rec_ap_fk(Integer id_rec_ap_fk) {
		this.id_rec_ap_fk = id_rec_ap_fk;
	}
	
}
