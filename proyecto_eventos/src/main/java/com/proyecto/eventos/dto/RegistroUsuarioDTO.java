package com.proyecto.eventos.dto;

import java.time.LocalDateTime;

public class RegistroUsuarioDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private LocalDateTime fechaRegistro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public RegistroUsuarioDTO(String nombre, String apellido, String email, String password, LocalDateTime fechaRegistro) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
	}

	public RegistroUsuarioDTO() {

	}

	

}
