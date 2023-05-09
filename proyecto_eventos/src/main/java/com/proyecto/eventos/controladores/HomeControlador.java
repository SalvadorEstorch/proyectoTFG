package com.proyecto.eventos.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("")
public class HomeControlador {

	@Autowired
	private EventoRepositorio eRepo;

	@GetMapping("")
    public ModelAndView verPaginaDeInicio() {
        List<Evento> ultimosEventos = eRepo.findAll(PageRequest.of(0,4,Sort.by("fechaInicio").descending())).toList();
        return new ModelAndView("index")
                      .addObject("ultimosEventos", ultimosEventos);

    }
	
	@GetMapping("/eventos")
	public ModelAndView listarEventos(@PageableDefault(sort = "fechaInicio",direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Evento> eventos = eRepo.findAll(pageable);
		return new ModelAndView("eventos")
				        .addObject("eventos",eventos);
	}
	
	
	@GetMapping("/eventos/{idEvento}")
	public ModelAndView mostrarDetallesEvento(@PathVariable Integer idEvento) {
		Evento evento = eRepo.getOne(idEvento);
		return new ModelAndView("evento").addObject("evento",evento);
	}
}
