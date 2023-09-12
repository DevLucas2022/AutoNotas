package com.remedios.lucas.curso.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    UserDetails findByLogin(String login);
}
