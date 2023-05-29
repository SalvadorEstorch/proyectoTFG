package com.proyecto.eventos.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.eventos.modelo.Usuario;
import com.proyecto.eventos.repositorios.UsuarioRepositorio;
@Service
public class RegistroUsuarioDao {
	
//	@Autowired
//	  private UsuarioRepositorio usuarioRepository;
//
//	  @Autowired
//	  private PerfilRepositorio perfileRepository;
//
//	  @Autowired
//	  private UsuarioPerfilRepositorio usuariosPerfileRepository;
//
//	  @Transactional
//	  public void registrarUsuario(String username, String password, String direccion, String email, String nombre) {
//	    // Crear un objeto Usuario y establecer sus propiedades
//	    Usuario usuario = new Usuario();
//	    usuario.setUsername(username);
//	    usuario.setPassword(password);
//	    usuario.setDireccion(direccion);
//	    usuario.setEmail(email);
//	    usuario.setNombre(nombre);
//	    usuario.setEnabled(1);
//	    
//
//	    // Crear una lista de objetos Perfile a partir de los IDs recibidos
//	    List<Perfile> perfiles = new ArrayList()<>();
//	    for (Integer idPerfil : id_perfile) {
//	      Optional<Perfile> optionalPerfile = perfileRepository.findById(idPerfil);
//	      if (optionalPerfile.isPresent()) {
//	        perfiles.add(optionalPerfile.get());
//	      }
//	    }
//
//	    // Establecer la relación entre el objeto Usuario y los objetos Perfile
//	    List<UsuariosPerfile> usuariosPerfiles = new ArrayList<>();
//	    for (Perfile perfile : perfiles) {
//	      UsuariosPerfile usuariosPerfile = new UsuariosPerfile();
//	      usuariosPerfile.setUsuario(usuario);
//	      usuariosPerfile.setPerfile(perfile);
//	      usuariosPerfiles.add(usuariosPerfile);
//	    }
//
//	    // Guardar el objeto Usuario
//	    usuarioRepository.save(usuario);
//
//	    // Guardar la lista de objetos UsuariosPerfile
//	    usuariosPerfileRepository.saveAll(usuariosPerfiles);
//	  }
	}