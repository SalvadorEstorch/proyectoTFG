package com.proyecto.eventos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.proyecto.eventos.modelo.Evento;
import com.proyecto.eventos.repositorios.EventoRepositorio;

@Controller
@RequestMapping("")
public class HomeControlador {

	@Autowired
	private EventoRepositorio eRepo;
	@Autowired

	@GetMapping("")
	public ModelAndView verEventosActivos() {
	    Page<Evento> eventosActivos = eRepo.findByActivo(1, null);
	    return new ModelAndView("index")
	                  .addObject("eventos", eventosActivos);
	}
}
