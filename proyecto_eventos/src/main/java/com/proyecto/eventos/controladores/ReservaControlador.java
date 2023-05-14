package com.proyecto.eventos.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.eventos.modelo.Reserva;
import com.proyecto.eventos.servicio.ReservaDao;



@RestController
public class ReservaControlador {

    @Autowired
    private ReservaDao reservaRepo;
    
   

    // Endpoint para crear una nueva reserva
    @PostMapping("/reservas/crear")
    public String crearReserva(@RequestBody Reserva reserva, RedirectAttributes attributes) {
        Reserva reservaCreada = reservaRepo.crearReserva(reserva);
        
        // Agregar el mensaje personalizado como atributo para la redirección
        attributes.addFlashAttribute("mensaje", "Reserva guardada con éxito");

        // Redirigir al index
        return "redirect:/index";
    }
    
    

    // Endpoint para obtener todas las reservas
    @GetMapping("/todas")
    public ResponseEntity<List<Reserva>> obtenerReservas() {
        List<Reserva> reservas = reservaRepo.obtenerTodasReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    // Endpoint para obtener una reserva por su ID
    @GetMapping("/verUna/{id}")
    public ResponseEntity<Reserva> verUna(@PathVariable int id) {
        Reserva reserva = reservaRepo.obtenerReserva(id);
        if (reserva != null) {
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
