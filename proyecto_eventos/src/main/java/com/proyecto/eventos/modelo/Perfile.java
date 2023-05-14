package com.proyecto.eventos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;





/**
 * The persistent class for the perfiles database table.
 * 
 */
@Entity
@Table(name="perfiles")
@NamedQuery(name="Perfile.findAll", query="SELECT p FROM Perfile p")
public class Perfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private int id_perfil;

	private String nombre;


	public Perfile() {
		super();
	}
	
	public Perfile(String nombre) {
		super();
		
		this.nombre = nombre;
	}



	public Perfile(int id_perfil, String nombre) {
		super();
		this.id_perfil = id_perfil;
		this.nombre = nombre;
	}



	

	public int getId_perfil() {
		return id_perfil;
	}



	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}



	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}