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
import com.proyecto.eventos.repositorios.ReservaRepositorio;
import com.proyecto.eventos.servicio.ReservaDao;



@Controller
@RequestMapping("/reservas")
public class ReservaControlador {

    @Autowired
    private ReservaRepositorio reservaRepo;
    
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
            reservas = reservaRepo.findAll(pageable);
        } else {
            // Obtener los detalles del usuario actual
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Obtener el correo electrónico del usuario actual
            String email = userDetails.getUsername();

            // Realizar la consulta de reservas filtrando por el correo electrónico del usuario
            reservas = reservaRepo.findByUsuarioEmail(email, pageable);
        }

        return new ModelAndView("reservas")
                .addObject("reservas", reservas);
    }


    @PostMapping("/{id}/eliminar")
	public String eliminarReserva(@PathVariable Integer id) {
		Reserva reserva = reservaRepo.getOne(id);
		reservaRepo.delete(reserva);
		
		return "redirect:/reservas";
	}
}
