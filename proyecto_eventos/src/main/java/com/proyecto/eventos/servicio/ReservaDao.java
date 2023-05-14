package com.proyecto.eventos.servicio;

import java.util.List;

import com.proyecto.eventos.modelo.Reserva;


public interface ReservaDao {
	
	public Reserva crearReserva(Reserva reserva);
    public Reserva obtenerReserva(int idReserva);
    public List<Reserva> obtenerTodasReservas();
    public void eliminarReserva(int idReserva);
	
}
