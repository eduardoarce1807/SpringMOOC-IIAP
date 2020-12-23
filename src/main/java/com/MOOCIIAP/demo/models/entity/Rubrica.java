package com.MOOCIIAP.demo.models.entity;

public class Rubrica {

	private Integer id_rubrica;
	private String nombre;
	private int ponderado;
	private String estado;
	private Integer id_curso_fk;
	private Integer id_modulo_fk;
	
	public Rubrica(Integer id_rubrica, String nombre, int ponderado, String estado, Integer id_curso_fk,
			Integer id_modulo_fk) {
		this.id_rubrica = id_rubrica;
		this.nombre = nombre;
		this.ponderado = ponderado;
		this.estado = estado;
		this.id_curso_fk = id_curso_fk;
		this.id_modulo_fk = id_modulo_fk;
	}
	
	public Rubrica() {
	}

	public Integer getId_rubrica() {
		return id_rubrica;
	}

	public void setId_rubrica(Integer id_rubrica) {
		this.id_rubrica = id_rubrica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPonderado() {
		return ponderado;
	}

	public void setPonderado(int ponderado) {
		this.ponderado = ponderado;
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

	public Integer getId_modulo_fk() {
		return id_modulo_fk;
	}

	public void setId_modulo_fk(Integer id_modulo_fk) {
		this.id_modulo_fk = id_modulo_fk;
	}
	
}
