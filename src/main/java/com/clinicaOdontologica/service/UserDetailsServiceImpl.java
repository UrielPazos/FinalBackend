package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Usuario;
import com.clinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByUsername(username);

        if (optionalUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Usuario usuario = optionalUsuario.get();

        // Log para verificar los roles cargados
        System.out.println("Roles cargados para el usuario " + username + ": " + usuario.getRoles());

        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRoles()))
        );
    }
}



