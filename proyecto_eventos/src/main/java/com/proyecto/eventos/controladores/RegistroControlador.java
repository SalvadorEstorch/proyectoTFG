package com.proyecto.eventos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.eventos.modelo.Usuario;
import com.proyecto.eventos.servicio.ReservaDao;
import com.proyecto.eventos.servicio.UsuarioDao;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioDao uRepo;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", uRepo.listarUsuarios());
		return "index";
	}
	
	@GetMapping("/accederLogin")
	public String accederLogin(@RequestParam String username, @RequestParam String password) {
		
		
		Usuario usuario = uRepo.findUser(username, password);
		
		if(usuario == null) {
			
			return "login";
		}		
		
		return "index";
	}
	
}