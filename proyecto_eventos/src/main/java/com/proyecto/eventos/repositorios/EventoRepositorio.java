package com.proyecto.eventos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.eventos.modelo.Evento;

public interface EventoRepositorio extends JpaRepository<Evento, Integer> {

}
