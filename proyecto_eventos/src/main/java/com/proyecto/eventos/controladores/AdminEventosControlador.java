package com.proyecto.eventos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.eventos.modelo.Evento;
import com.proyecto.eventos.modelo.Usuario;
import com.proyecto.eventos.repositorios.EventoRepositorio;
import com.proyecto.eventos.repositorios.UsuarioRepositorio;
import com.proyecto.eventos.servicio.AlmacenServicioImpl;

@Controller
@RequestMapping("/admin")
public class AdminEventosControlador {

	@Autowired
	private EventoRepositorio eRepo;

	@Autowired
	private AlmacenServicioImpl servicio;
	
	@Autowired
	private UsuarioRepositorio uRepo;

	
	@GetMapping("")
	public ModelAndView verPaginaDeInicio(@PageableDefault Pageable pageable, RedirectAttributes redirectAttributes) {
	    Page<Evento> eventos = eRepo.findAll(pageable);
	    Page<Usuario> usuarios = uRepo.findAll(pageable);

	    String activeTab = "eventos"; // Pestaña de eventos como predeterminada

	    if (redirectAttributes.containsAttribute("activeTab")) {
	        activeTab = (String) redirectAttributes.getFlashAttributes().get("activeTab");
	    }

	    return new ModelAndView("admin/index")
	            .addObject("eventos", eventos)
	            .addObject("usuarios", usuarios)
	            .addObject("activeTab", activeTab);
	}

	@GetMapping("/eventos/nuevo")
	public ModelAndView mostrarFormularioDeNuevoEvento() {
		return new ModelAndView("admin/nuevo-evento")
				.addObject("evento", new Evento());
	}
	
	@PostMapping("/eventos/nuevo")
	public ModelAndView registrarEvento(@Validated Evento evento,BindingResult bindingResult) {
		if(bindingResult.hasErrors() || evento.getPortada().isEmpty()) {
			if(evento.getPortada().isEmpty()) {
				bindingResult.rejectValue("portada","MultipartNotEmpty");
			}
			return new ModelAndView("admin/nuevo-evento")
					.addObject("evento",evento);
		}

		String rutaPortada = servicio.almacenarArchivo(evento.getPortada());
		evento.setRutaPortada(rutaPortada);
		
		eRepo.save(evento);
		return new ModelAndView("redirect:/admin");
	}
	
	@GetMapping("/eventos/{id}/editar")
	public ModelAndView mostrarFormilarioDeEditarEvento(@PathVariable Integer id) {
		Evento evento = eRepo.getOne(id);
		
		return new ModelAndView("admin/editar-evento")
				.addObject("evento",evento);
	}
	
	@PostMapping("/eventos/{id}/editar")
	public ModelAndView actualizarEvento(@PathVariable Integer id,@Validated Evento evento,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("admin/editar-evento")
					.addObject("evento",evento);
		}
		
		Evento eventoDB = eRepo.getOne(id);
		eventoDB.setActivo(evento.getActivo());
		eventoDB.setAforoMax(evento.getAforoMax());
		eventoDB.setCiudad(evento.getCiudad());
		eventoDB.setDescripcionE(evento.getDescripcionE());
		eventoDB.setDestacado(evento.getDestacado());
		eventoDB.setDireccion(evento.getDireccion());
		eventoDB.setDuracion(evento.getDuracion());
		eventoDB.setFechaInicio(evento.getFechaInicio());
		eventoDB.setMinimoAsistencia(evento.getMinimoAsistencia());
		eventoDB.setNombreE(evento.getNombreE());
		eventoDB.setPrecioDecimal(evento.getPrecioDecimal());
		eventoDB.setTipo(evento.getTipo());
		eventoDB.setPortada(evento.getPortada());
		eventoDB.setYoutubeTrailerId(evento.getYoutubeTrailerId());
		
		if(!evento.getPortada().isEmpty()) {
			servicio.eliminarArchivo(eventoDB.getRutaPortada());
			String rutaPortada = servicio.almacenarArchivo(evento.getPortada());
			eventoDB.setRutaPortada(rutaPortada);
		}
		
		eRepo.save(eventoDB);
		return new ModelAndView("redirect:/admin");
	}
	
	@PostMapping("/eventos/{id}/eliminar")
	public String eliminarEvento(@PathVariable Integer id) {
		Evento evento = eRepo.getOne(id);
		eRepo.delete(evento);
		servicio.eliminarArchivo(evento.getRutaPortada());
		
		return "redirect:/admin";
	}
	
	@GetMapping("/eventos/{id}/desactivar")
	public String desactivarEvento(@PathVariable Integer id) {
		Evento evento = eRepo.getOne(id);
		evento.setActivo(0);
		eRepo.save(evento);
		
		return "redirect:/admin";
	}
	
	@GetMapping("/eventos/{id}/activar")
	public String activarEvento(@PathVariable Integer id) {
		Evento evento = eRepo.getOne(id);
		evento.setActivo(1);
		eRepo.save(evento);
		
		return "redirect:/admin";
	}
	
 
}
