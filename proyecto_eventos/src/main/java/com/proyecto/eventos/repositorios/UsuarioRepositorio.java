package com.proyecto.eventos.repositorios;







import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.eventos.modelo.Usuario;







public interface UsuarioRepositorio extends JpaRepository<com.proyecto.eventos.modelo.Usuario, String> {


	@Query(value = "select * from usuarios where username = :username and password = :password", nativeQuery = true)
	  Usuario findUsuario(@Param(value="username") String username, @Param(value="password") String password);
	
}