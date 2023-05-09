package com.proyecto.eventos.modelo;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the usuarios_perfiles database table.
 * 
 */
@Entity
@Table(name="usuarios_perfiles")
@NamedQuery(name="UsuariosPerfile.findAll", query="SELECT u FROM UsuariosPerfile u")
public class UsuariosPerfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//uni-directional many-to-one association to Perfile
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfile perfile;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="username")
	private Usuario usuario;

	public UsuariosPerfile() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perfile getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}