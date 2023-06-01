//package com.proyecto.eventos.controladores;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.proyecto.eventos.servicio.UsuarioDao;
//
//@Controller
//public class RegistroControlador {
//
//	@Autowired
//	private UsuarioDao usuarioDao;
//	
//	@GetMapping("/login")
//	public String iniciarSesion() {
//		return "login";
//	}
//	
////	@GetMapping("/login/alta")
////	public String verPaginaDeInicio(Model modelo) {
////		modelo.addAttribute("usuarios", usuarioDao.listarUsuarios());
////		return "index";
////	}
//}