package com.proyecto.eventos.repositorios;







import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.eventos.modelo.Reserva;








public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {


	
}