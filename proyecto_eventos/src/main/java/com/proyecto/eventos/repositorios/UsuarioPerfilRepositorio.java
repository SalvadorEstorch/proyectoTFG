package com.proyecto.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;



import com.proyecto.eventos.modelo.UsuariosPerfile;

public interface UsuarioPerfilRepositorio extends JpaRepository<UsuariosPerfile, Integer> {

}
