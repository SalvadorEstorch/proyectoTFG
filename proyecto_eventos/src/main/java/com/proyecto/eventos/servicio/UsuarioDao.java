package com.proyecto.eventos.servicio;

import java.util.List;

import com.proyecto.eventos.dto.RegistroUsuarioDTO;
import com.proyecto.eventos.modelo.Usuario;

public interface UsuarioDao {
	
	Usuario buscarUno(String email);
//	boolean registro(Usuario usuario);
	public Usuario guardar(RegistroUsuarioDTO RegistroDTO);
	Usuario findUser(String username, String password);
	public List<Usuario> listarUsuarios();
	

}
