package com.proyecto.eventos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.eventos.modelo.Evento;
import com.proyecto.eventos.repositorios.EventoRepositorio;


@Controller
@RequestMapping("/eventos")
public class EventosControlador {
	
	@Autowired
	private EventoRepositorio eRepo;
	
	@GetMapping("")
	public ModelAndView listarEventos(@PageableDefault(sort = "fechaInicio",direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Evento> eventos = (Page<Evento>) eRepo.findByActivo(1, null);
		return new ModelAndView("eventos")
				        .addObject("eventos",eventos);
	}
	
	@GetMapping("/{idEvento}")
	public ModelAndView mostrarDetallesEvento(@PathVariable Integer idEvento) {
		Evento evento = eRepo.getOne(idEvento);
		return new ModelAndView("evento").addObject("evento",evento);
	}

}
