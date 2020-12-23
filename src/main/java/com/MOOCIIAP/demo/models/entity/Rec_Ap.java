package com.MOOCIIAP.demo.models.entity;

public class Rec_Ap {

	private Integer id_rec_ap;
	private int nota;
	private String titulo;
	private String url;
	private String completada;
	private String estado;
	private Integer id_sesion_fk;
	private Integer id_tipo_rec_ap_fk;
	private Integer id_rubrica_fk;

	public Rec_Ap(Integer id_rec_ap, int nota, String titulo, String url, String completada, String estado,
			Integer id_sesion_fk, Integer id_tipo_rec_ap_fk, Integer id_rubrica_fk) {
		this.id_rec_ap = id_rec_ap;
		this.nota = nota;
		this.titulo = titulo;
		this.url = url;
		this.completada = completada;
		this.estado = estado;
		this.id_sesion_fk = id_sesion_fk;
		this.id_tipo_rec_ap_fk = id_tipo_rec_ap_fk;
		this.id_rubrica_fk = id_rubrica_fk;
	}

	public Rec_Ap() {
	}

	public Integer getId_rec_ap() {
		return id_rec_ap;
	}

	public void setId_rec_ap(Integer id_rec_ap) {
		this.id_rec_ap = id_rec_ap;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCompletada() {
		return completada;
	}

	public void setCompletada(String completada) {
		this.completada = completada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_sesion_fk() {
		return id_sesion_fk;
	}

	public void setId_sesion_fk(Integer id_sesion_fk) {
		this.id_sesion_fk = id_sesion_fk;
	}

	public Integer getId_tipo_rec_ap_fk() {
		return id_tipo_rec_ap_fk;
	}

	public void setId_tipo_rec_ap_fk(Integer id_tipo_rec_ap_fk) {
		this.id_tipo_rec_ap_fk = id_tipo_rec_ap_fk;
	}

	public Integer getId_rubrica_fk() {
		return id_rubrica_fk;
	}

	public void setId_rubrica_fk(Integer id_rubrica_fk) {
		this.id_rubrica_fk = id_rubrica_fk;
	}

}
