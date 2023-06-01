package com.proyecto.eventos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.eventos.dto.RegistroUsuarioDTO;
import com.proyecto.eventos.modelo.Reserva;
import com.proyecto.eventos.modelo.Usuario;
import com.proyecto.eventos.repositorios.ReservaRepositorio;
import com.proyecto.eventos.repositorios.UsuarioRepositorio;
import com.proyecto.eventos.servicio.UsuarioDao;

@Controller
@RequestMapping("")
public class UsuarioControlador {

	private UsuarioDao usuarioDao;

	public UsuarioControlador(UsuarioDao usuarioServicio) {
		super();
		this.usuarioDao = usuarioServicio;
	}	
	
	@Autowired
	private UsuarioRepositorio uRepo;
	@Autowired
    private ReservaRepositorio rRepo;
	
	@GetMapping("/usuarios")
	public ModelAndView listarUsuarios(@PageableDefault(sort = "fechaRegistro",direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Usuario> usuarios = uRepo.findAll(pageable);
		return new ModelAndView("usuarios")
				        .addObject("usuarios",usuarios);
	}
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
		
	@ModelAttribute("usuario")
	public RegistroUsuarioDTO retornarNuevoUsuarioRegistroDTO() {
		return new RegistroUsuarioDTO();
	}

	@GetMapping("/registro")
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") RegistroUsuarioDTO registroDTO, Model model) {
	    Usuario usuarioExistente = uRepo.findByEmail(registroDTO.getEmail());
	    if (usuarioExistente != null) {
	        model.addAttribute("error", "El usuario ya existe");
	        return "registro"; 
	    }
	    
	    usuarioDao.guardar(registroDTO);
	    return "redirect:/login";
	}
	
	
	@PostMapping("/usuarios/{id}/eliminar")
	public String eliminarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
	    try {
	        Usuario usuario = uRepo.getOne(id);

	        // Obtener las reservas asociadas al usuario
	        List<Reserva> reservas = rRepo.findByUsuario(usuario);

	        // Verificar si hay reservas asociadas al usuario
	        if (!reservas.isEmpty()) {
	            throw new DataIntegrityViolationException("No se puede eliminar el usuario porque tiene reservas asociadas.");
	        }

	        // Eliminar todas las relaciones entre el usuario y los roles
	        usuario.getRoles().clear();

	        // Guardar los cambios en la base de datos
	        uRepo.save(usuario);

	        // Eliminar el usuario
	        uRepo.delete(usuario);

	        return "redirect:/usuarios";
	    } catch (DataIntegrityViolationException e) {
	        // Capturar la excepción y mostrar un mensaje adecuado en la página de usuarios
	        redirectAttributes.addFlashAttribute("errorMessage", "No se puede eliminar el usuario porque tiene reservas asociadas.");
	        return "redirect:/usuarios";
	    }
	}
}
