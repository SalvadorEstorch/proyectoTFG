package com.proyecto.eventos.repositorios;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import com.proyecto.eventos.modelo.Evento;

public interface EventoRepositorio extends JpaRepository<Evento, Integer> {

	Page<Evento> findByActivo(int activo, Pageable pageable);
}
