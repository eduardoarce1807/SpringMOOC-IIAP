package com.MOOCIIAP.demo.models.entity;

public class Registro {

	private Integer id_registro;
	private Integer nota;
	private String aprobado;
	private String estado;
	private Integer id_rubrica_fk;
	private Integer id_inscripcion_fk;
	
	public Registro(Integer id_registro, Integer nota, String aprobado, String estado, Integer id_rubrica_fk,
			Integer id_inscripcion_fk) {
		this.id_registro = id_registro;
		this.nota = nota;
		this.aprobado = aprobado;
		this.estado = estado;
		this.id_rubrica_fk = id_rubrica_fk;
		this.id_inscripcion_fk = id_inscripcion_fk;
	}
	
	public Registro() {
	}

	public Integer getId_registro() {
		return id_registro;
	}

	public void setId_registro(Integer id_registro) {
		this.id_registro = id_registro;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getAprobado() {
		return aprobado;
	}

	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_rubrica_fk() {
		return id_rubrica_fk;
	}

	public void setId_rubrica_fk(Integer id_rubrica_fk) {
		this.id_rubrica_fk = id_rubrica_fk;
	}

	public Integer getId_inscripcion_fk() {
		return id_inscripcion_fk;
	}

	public void setId_inscripcion_fk(Integer id_inscripcion_fk) {
		this.id_inscripcion_fk = id_inscripcion_fk;
	}
	
}
