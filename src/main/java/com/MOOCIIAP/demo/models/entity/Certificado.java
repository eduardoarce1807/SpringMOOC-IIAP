package com.MOOCIIAP.demo.models.entity;

public class Certificado {

	private String codigo;
	private String estado;
	private Integer id_inscripcion_fk;
	
	public Certificado(String codigo, String estado, Integer id_inscripcion_fk) {
		this.codigo = codigo;
		this.estado = estado;
		this.id_inscripcion_fk = id_inscripcion_fk;
	}

	public Certificado() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_inscripcion_fk() {
		return id_inscripcion_fk;
	}

	public void setId_inscripcion_fk(Integer id_inscripcion_fk) {
		this.id_inscripcion_fk = id_inscripcion_fk;
	}

}
