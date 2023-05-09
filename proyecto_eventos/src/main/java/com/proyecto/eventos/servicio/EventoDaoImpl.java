package com.proyecto.eventos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.eventos.modelo.Evento;
import com.proyecto.eventos.repositorios.EventoRepositorio;


public class EventoDaoImpl implements EventoDao {
	
	@Autowired
	EventoRepositorio eventoRepo;
	
//	@Override
//	public Evento findById(int idEvento) {
//		return eventoRepo.findById(idEvento).orElse(null);
//	}
	
	@Override		
	public boolean registro(Evento evento) {
		
		if (buscarUno(evento.getIdEvento()) == null) {
			eventoRepo.save(evento);
			return true;
		}
		return false;
		
	}
	
	@Override
	public Evento buscarUno(int idEvento) {
		
		return eventoRepo.findById(idEvento).orElse(null);
	}
	
//	@Override
//	public List<Evento> eventoactivos() {
//		// TODO Auto-generated method stub
//		return eventoRepo.eventoactivos();
//	}
//	
//	@Override
//	public List<Evento> eventosdestacados() {
//		// TODO Auto-generated method stub
//		return eventoRepo.eventosdestacados();
//	}
	
	//El método debe devolver un null cuando no da de alta
	@Override
	public Evento altaEvento(Evento evento) {
		return eventoRepo.save(evento);
	}
	
//	@Override
//	public Evento modificarEvento(Evento evento) {
//		// TODO Auto-generated method stub
//		try {
//			return eventoRepo.save(evento);
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null; 
//		}
//	}

	@Override
	public void eliminarEvento(int idEvento) {
		
		eventoRepo.deleteById(idEvento);
	}

	@Override
	public List<Evento> listaEventos() {
		// TODO Auto-generated method stub
		return eventoRepo.findAll();
	}
	
	@Override
	public Evento modificarEvento(Evento evento) {
	    if (buscarUno(evento.getIdEvento()) == null) {
	        return null;
	    } else {
	        return eventoRepo.save(evento);
	    }
	}

}
