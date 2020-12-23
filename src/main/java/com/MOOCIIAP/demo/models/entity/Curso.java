package com.MOOCIIAP.demo.models.entity;

public class Curso {
	
	private Integer id_curso;
	private String titulo;
	private String subtitulo;
	private int precio;
	private String ruta_img;
	private String ruta_vid;
	private String url;
	private int duracion;
	private String certificacion_tit;
	private String certificadora;
	private String certificadora_2;
	private String objetivo;
	private String perfil_participante;
	private String metodologia;
	private String competencias;
	private String fecha_creacion;
	private String estado;
	private Integer id_categoria_fk;

	public Curso(Integer id_curso, String titulo, String subtitulo, int precio, String ruta_img, String ruta_vid,
			String url, int duracion, String certificacion_tit, String certificadora, String certificadora_2,
			String objetivo, String perfil_participante, String metodologia, String competencias, String fecha_creacion,
			String estado, Integer id_categoria_fk) {
		this.id_curso = id_curso;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.precio = precio;
		this.ruta_img = ruta_img;
		this.ruta_vid = ruta_vid;
		this.url = url;
		this.duracion = duracion;
		this.certificacion_tit = certificacion_tit;
		this.certificadora = certificadora;
		this.certificadora_2 = certificadora_2;
		this.objetivo = objetivo;
		this.perfil_participante = perfil_participante;
		this.metodologia = metodologia;
		this.competencias = competencias;
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;
		this.id_categoria_fk = id_categoria_fk;
	}

	public Curso() {
	}

	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getRuta_img() {
		return ruta_img;
	}

	public void setRuta_img(String ruta_img) {
		this.ruta_img = ruta_img;
	}

	public String getRuta_vid() {
		return ruta_vid;
	}

	public void setRuta_vid(String ruta_vid) {
		this.ruta_vid = ruta_vid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getCertificacion_tit() {
		return certificacion_tit;
	}

	public void setCertificacion_tit(String certificacion_tit) {
		this.certificacion_tit = certificacion_tit;
	}

	public String getCertificadora() {
		return certificadora;
	}

	public void setCertificadora(String certificadora) {
		this.certificadora = certificadora;
	}

	public String getCertificadora_2() {
		return certificadora_2;
	}

	public void setCertificadora_2(String certificadora_2) {
		this.certificadora_2 = certificadora_2;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getPerfil_participante() {
		return perfil_participante;
	}

	public void setPerfil_participante(String perfil_participante) {
		this.perfil_participante = perfil_participante;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_categoria_fk() {
		return id_categoria_fk;
	}

	public void setId_categoria_fk(Integer id_categoria_fk) {
		this.id_categoria_fk = id_categoria_fk;
	}

}
