package com.proyecto.eventos.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.eventos.modelo.Evento;
import com.proyecto.eventos.modelo.Reserva;
import com.proyecto.eventos.modelo.Usuario;
import com.proyecto.eventos.repositorios.EventoRepositorio;
import com.proyecto.eventos.repositorios.ReservaRepositorio;
import com.proyecto.eventos.repositorios.UsuarioRepositorio;
import com.proyecto.eventos.servicio.ReservaDao;



@Controller
@RequestMapping("/reservas")
public class ReservaControlador {

	@Autowired
	private EventoRepositorio eRepo;
	@Autowired
	private UsuarioRepositorio uRepo;
	@Autowired
    private ReservaRepositorio rRepo;
    
    // Endpoint para obtener todas las reservas
    @GetMapping("")
    public ModelAndView listarReservas(@PageableDefault Pageable pageable) {
        // Obtener el objeto de autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificar el rol del usuario actual
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        Page<Reserva> reservas;
        
        if (isAdmin) {
            // Si el usuario es administrador, obtener todas las reservas
            reservas = rRepo.findAll(pageable);
        } else {
            // Obtener los detalles del usuario actual
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Obtener el correo electrónico del usuario actual
            String email = userDetails.getUsername();

            // Realizar la consulta de reservas filtrando por el correo electrónico del usuario
            reservas = rRepo.findByUsuarioEmail(email, pageable);
        }

        return new ModelAndView("reservas")
                .addObject("reservas", reservas);
    }


    @PostMapping("/{id}/eliminar")
	public String eliminarReserva(@PathVariable Integer id) {
		Reserva reserva = rRepo.getOne(id);
		rRepo.delete(reserva);
		
		return "redirect:/reservas";
	}
    
    @GetMapping("/{id}/reservarEvento")
	public ModelAndView formReservaEvento(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("altaReserva"); //formulario para reserva
	    modelAndView.addObject("reserva", new Reserva());
	    
	    return modelAndView;
	}
	
	@PostMapping("/{id}/reservarEvento")
    public String registrarReservaEvento(@PathVariable Integer id,@Validated Reserva reserva,BindingResult bindingResult, Model model) {
		Evento evento = eRepo.getOne(id);

	    // Obtener el usuario autenticado
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName(); // Se obtiene el username del usuario logado
	    Usuario usuario = uRepo.findByEmail(username);

	    // Verificar si el usuario ya ha reservado este evento
	    if (rRepo.existsByEventoAndUsuario(evento, usuario)) {
	    	String mensajeError = "Ya has reservado este evento.";
	        model.addAttribute("mensajeError", mensajeError);
	        return "altaReserva";
	    }

	   

	    reserva.setEvento(evento); // Asignar el evento a la reserva
	    reserva.setUsuario(usuario); // Asignar el usuario a la reserva
	    rRepo.save(reserva);

	    return "redirect:/reservas";
	}
}
