package com.MOOCIIAP.demo.models.entity;

public class Alternativa {

	private Integer id_alternativa;
	private String nombre;
	private String estado;
	private String correcta;
	private Integer id_pregunta_fk;

	

	public Alternativa(Integer id_alternativa, String nombre, String estado, String correcta, Integer id_pregunta_fk) {
		this.id_alternativa = id_alternativa;
		this.nombre = nombre;
		this.estado = estado;
		this.correcta = correcta;
		this.id_pregunta_fk = id_pregunta_fk;
	}

	public Alternativa() {
	}

	public Integer getId_alternativa() {
		return id_alternativa;
	}

	public void setId_alternativa(Integer id_alternativa) {
		this.id_alternativa = id_alternativa;
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

	public String getCorrecta() {
		return correcta;
	}

	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	}

	public Integer getId_pregunta_fk() {
		return id_pregunta_fk;
	}
	
	public void setId_pregunta_fk(Integer id_pregunta_fk) {
		this.id_pregunta_fk = id_pregunta_fk;
	}

}
