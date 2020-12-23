package com.MOOCIIAP.demo.models.entity;

public class Inscripcion {

	private Integer id_inscripcion;
	private int nota_final;
	private Integer progreso;
	private String estado;
	private Integer id_curso_fk;
	private Integer id_usuario_fk;
	
	public Inscripcion(Integer id_inscripcion, int nota_final, Integer progreso, String estado, Integer id_curso_fk,
			Integer id_usuario_fk) {
		this.id_inscripcion = id_inscripcion;
		this.nota_final = nota_final;
		this.progreso = progreso;
		this.estado = estado;
		this.id_curso_fk = id_curso_fk;
		this.id_usuario_fk = id_usuario_fk;
	}

	public Inscripcion() {
	}

	public Integer getId_inscripcion() {
		return id_inscripcion;
	}

	public void setId_inscripcion(Integer id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}

	public int getNota_final() {
		return nota_final;
	}

	public void setNota_final(int nota_final) {
		this.nota_final = nota_final;
	}

	public Integer getProgreso() {
		return progreso;
	}

	public void setProgreso(Integer progreso) {
		this.progreso = progreso;
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

	public Integer getId_usuario_fk() {
		return id_usuario_fk;
	}

	public void setId_usuario_fk(Integer id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}

}
