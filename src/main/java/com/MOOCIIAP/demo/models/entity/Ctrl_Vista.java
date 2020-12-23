package com.MOOCIIAP.demo.models.entity;

public class Ctrl_Vista {

	private Integer id_ctrl_vista;
	private String visto;
	private String estado;
	private Integer id_rec_ap_fk;
	private Integer id_inscripcion_fk;
	
	public Ctrl_Vista(Integer id_ctrl_vista, String visto, String estado, Integer id_rec_ap_fk,
			Integer id_inscripcion_fk) {
		this.id_ctrl_vista = id_ctrl_vista;
		this.visto = visto;
		this.estado = estado;
		this.id_rec_ap_fk = id_rec_ap_fk;
		this.id_inscripcion_fk = id_inscripcion_fk;
	}

	public Ctrl_Vista() {
	}

	public Integer getId_ctrl_vista() {
		return id_ctrl_vista;
	}

	public void setId_ctrl_vista(Integer id_ctrl_vista) {
		this.id_ctrl_vista = id_ctrl_vista;
	}

	public String getVisto() {
		return visto;
	}

	public void setVisto(String visto) {
		this.visto = visto;
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

	public Integer getId_rec_ap_fk() {
		return id_rec_ap_fk;
	}

	public void setId_rec_ap_fk(Integer id_rec_ap_fk) {
		this.id_rec_ap_fk = id_rec_ap_fk;
	}
	
}
