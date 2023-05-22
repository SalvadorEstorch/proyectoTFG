package com.proyecto.eventos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;




/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name="eventos")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEvento")
	private int idEvento;

	private byte activo;

	@Column(name="aforo_max")
	private int aforoMax;

	private String ciudad;

	@Column(name="descripcion_e")
	private String descripcionE;

	private String destacado;

	private String direccion;

	private int duracion;
	

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaInicio;
	

	@Column(name="minimo_asistencia")
	private int minimoAsistencia;

	@Column(name="nombre_e")
	private String nombreE;

	@Column(name="precio_decimal")
	private double precioDecimal;

	private String tipo;
	
	@Transient
	private MultipartFile portada;
	
	private String rutaPortada;
	
//	@NotBlank
	private String youtubeTrailerId;
	
	
	/*public Evento() {
	}*/

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	

	public byte getActivo() {
		return activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public int getAforoMax() {
		return this.aforoMax;
	}

	public void setAforoMax(int aforoMax) {
		this.aforoMax = aforoMax;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcionE() {
		return this.descripcionE;
	}

	public void setDescripcionE(String descripcionE) {
		this.descripcionE = descripcionE;
	}

	public String getDestacado() {
		return this.destacado;
	}

	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getMinimoAsistencia() {
		return this.minimoAsistencia;
	}

	public void setMinimoAsistencia(int minimoAsistencia) {
		this.minimoAsistencia = minimoAsistencia;
	}

	public String getNombreE() {
		return this.nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public double getPrecioDecimal() {
		return this.precioDecimal;
	}

	public void setPrecioDecimal(double precioDecimal) {
		this.precioDecimal = precioDecimal;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public MultipartFile getPortada() {
		return portada;
	}

	public void setPortada(MultipartFile portada) {
		this.portada = portada;
	}
	
	public String getRutaPortada() {
		return rutaPortada;
	}

	public void setRutaPortada(String rutaPortada) {
		this.rutaPortada = rutaPortada;
	}
	
	public String getYoutubeTrailerId() {
		return youtubeTrailerId;
	}

	public void setYoutubeTrailerId(String youtubeTrailerId) {
		this.youtubeTrailerId = youtubeTrailerId;
	}

	public Evento() {
		super();
	}

	public Evento(int idEvento, byte activo, int aforoMax, String ciudad, String descripcionE, String destacado,
			String direccion, int duracion, LocalDate fechaInicio, int minimoAsistencia, String nombreE,
			double precioDecimal, String tipo, MultipartFile portada, String rutaPortada, String youtubeTrailerId) {
		super();
		this.idEvento = idEvento;
		this.activo = activo;
		this.aforoMax = aforoMax;
		this.ciudad = ciudad;
		this.descripcionE = descripcionE;
		this.destacado = destacado;
		this.direccion = direccion;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.minimoAsistencia = minimoAsistencia;
		this.nombreE = nombreE;
		this.precioDecimal = precioDecimal;
		this.tipo = tipo;
		this.portada = portada;
		this.rutaPortada = rutaPortada;
		this.youtubeTrailerId = youtubeTrailerId;
	}

	public Evento(byte activo, int aforoMax, String ciudad, String descripcionE, String destacado, String direccion,
			int duracion, LocalDate fechaInicio, int minimoAsistencia, String nombreE, double precioDecimal, String tipo,
			MultipartFile portada, String rutaPortada, String youtubeTrailerId) {
		super();
		this.activo = activo;
		this.aforoMax = aforoMax;
		this.ciudad = ciudad;
		this.descripcionE = descripcionE;
		this.destacado = destacado;
		this.direccion = direccion;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.minimoAsistencia = minimoAsistencia;
		this.nombreE = nombreE;
		this.precioDecimal = precioDecimal;
		this.tipo = tipo;
		this.portada = portada;
		this.rutaPortada = rutaPortada;
		this.youtubeTrailerId = youtubeTrailerId;
	}

	
	

}