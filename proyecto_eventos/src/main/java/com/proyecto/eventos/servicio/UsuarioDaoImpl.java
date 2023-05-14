package com.proyecto.eventos.servicio;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proyecto.eventos.dto.RegistroUsuarioDTO;
import com.proyecto.eventos.modelo.Perfile;
import com.proyecto.eventos.modelo.Usuario;
import com.proyecto.eventos.repositorios.PerfilRepositorio;
import com.proyecto.eventos.repositorios.UsuarioRepositorio;
import com.proyecto.eventos.servicio.*;




@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	
	
	@Autowired
	UsuarioRepositorio uRepo;
	
	@Autowired
	PerfilRepositorio perfilRepo;
	
	 
	
	@Override
	public Usuario buscarUno(String email) {
		// TODO Auto-generated method stub
		return uRepo.findById(email).orElse(null);
	}
	
//	@Override
//	public boolean registro(Usuario usuario) {
//		if (buscarUno(usuario.getEmail()) == null) {
//				uRepo.save(usuario);
//				return true;
//		}
//		return false;
//	}
	
	@Override
	public Usuario findUser(String username, String password) {
		// TODO Auto-generated method stub
		return uRepo.findUsuario(username,password);
	}


@Override
public Usuario guardar(RegistroUsuarioDTO registroDTO) {
	 Usuario usuario = new Usuario();
     usuario.setUsername(registroDTO.getUsername());
     usuario.setEmail(registroDTO.getEmail());
     usuario.setEnabled(1);

     usuario.setNombre(registroDTO.getNombre());
     usuario.setPassword(registroDTO.getPassword());

     // Asignar un perfil por defecto al usuario
     
    // Optional<Perfile> perfile = perfilRepo.findById(1);

     //usuario.setpri
     return uRepo.save(usuario);
 }

@Override
public List<Usuario> listarUsuarios() {
	return uRepo.findAll();
}
}



	

