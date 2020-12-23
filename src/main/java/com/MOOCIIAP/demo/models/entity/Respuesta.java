package com.MOOCIIAP.demo.models.entity;

public class Respuesta {

	private Integer id_respuesta;
	private String estado;
	private Integer id_alternativa_fk;
	private Integer id_inscripcion_fk;

	public Respuesta(Integer id_respuesta, String estado, Integer id_alternativa_fk, Integer id_inscripcion_fk) {
		this.id_respuesta = id_respuesta;
		this.estado = estado;
		this.id_alternativa_fk = id_alternativa_fk;
		this.id_inscripcion_fk = id_inscripcion_fk;
	}

	public Respuesta() {
	}
	
	public Integer getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(Integer id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_alternativa_fk() {
		return id_alternativa_fk;
	}

	public void setId_alternativa_fk(Integer id_alternativa_fk) {
		this.id_alternativa_fk = id_alternativa_fk;
	}

	public Integer getId_inscripcion_fk() {
		return id_inscripcion_fk;
	}

	public void setId_inscripcion_fk(Integer id_inscripcion_fk) {
		this.id_inscripcion_fk = id_inscripcion_fk;
	}

}
