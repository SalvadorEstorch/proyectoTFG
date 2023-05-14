package com.proyecto.eventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.eventos.dto.RegistroUsuarioDTO;


import com.proyecto.eventos.servicio.UsuarioDao;



@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	private UsuarioDao usuarioServicio;

	public RegistroUsuarioControlador(UsuarioDao usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	
		
	@ModelAttribute("usuario")
	public RegistroUsuarioDTO retornarNuevoUsuarioRegistroDTO() {
		return new RegistroUsuarioDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") RegistroUsuarioDTO registroDTO) {
		usuarioServicio.guardar(registroDTO);
		return "login";
	}
}
