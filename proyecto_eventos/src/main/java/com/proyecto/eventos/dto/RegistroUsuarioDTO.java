package com.proyecto.eventos.dto;

import java.util.Date;

public class RegistroUsuarioDTO {

	private String username;

	private String nombre;

	private String email;

	private String password;

	public RegistroUsuarioDTO(String username, String nombre, String email, String password) {
		super();
		this.username = username;
		this.nombre = nombre;

		this.email = email;
		this.password = password;
	}

	public RegistroUsuarioDTO() {
		super();
	}

	public RegistroUsuarioDTO(String nombre, String email, String password) {
		super();
		this.nombre = nombre;

		this.email = email;
		this.password = password;
	}

	public RegistroUsuarioDTO(String email) {
		super();
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}
