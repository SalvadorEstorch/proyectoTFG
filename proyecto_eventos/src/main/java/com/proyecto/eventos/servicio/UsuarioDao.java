package com.proyecto.eventos.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proyecto.eventos.dto.RegistroUsuarioDTO;
import com.proyecto.eventos.modelo.Usuario;



public interface UsuarioDao extends UserDetailsService{

	public Usuario guardar(RegistroUsuarioDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
