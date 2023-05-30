package com.proyecto.eventos.repositorios;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.eventos.modelo.Reserva;
import com.proyecto.eventos.modelo.Usuario;

public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {

	List<Reserva> findByUsuario(Usuario usuario);

	Page<Reserva> findByUsuarioEmail(String id, Pageable pageable);
	
}