package com.proyecto.eventos.servicio;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.eventos.modelo.Reserva;
import com.proyecto.eventos.repositorios.ReservaRepositorio;


@Service
public class ReservaDaoImpl implements ReservaDao {
	
	@Autowired
	ReservaRepositorio reservaRepo;
	
	 @Override
	    public Reserva crearReserva(Reserva reserva) {
	        // Validar los datos de la reserva, por ejemplo:
	        if (reserva.getEvento() == null || reserva.getUsuario() == null) {
	            throw new IllegalArgumentException("Evento y usuario son obligatorios para crear una reserva");
	        }
	        
	        return reservaRepo.save(reserva);
	    }

	    @Override
	    public Reserva obtenerReserva(int idReserva) {
	        Optional<Reserva> optionalReserva = reservaRepo.findById(idReserva);
	        if (optionalReserva.isPresent()) {
	            return optionalReserva.get();
	        } else {
	            throw new NoSuchElementException("No se encontró ninguna reserva con id " + idReserva);
	        }
	    }

	    @Override
	    public List<Reserva> obtenerTodasReservas() {
	        return reservaRepo.findAll();
	    }

	    @Override
	    public void eliminarReserva(int idReserva) {
	    	reservaRepo.deleteById(idReserva);
	    }

}
