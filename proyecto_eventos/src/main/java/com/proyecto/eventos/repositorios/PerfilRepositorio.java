package com.proyecto.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto.eventos.modelo.Perfile;

public interface PerfilRepositorio extends JpaRepository<Perfile, Integer> {

}
