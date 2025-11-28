package com.cinepluss.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cinepluss.demo.model.Role;
import com.cinepluss.demo.model.Usuario;
import com.cinepluss.demo.repository.UsuarioRepository;

@Configuration
public class DataInitConfig {
    
    @Bean
    CommandLineRunner initUsers(UsuarioRepository usuarioRepository,
                                PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepository.count() == 0) {
                Usuario admin = Usuario.builder()
                    .nombre_usuario("admin")
                    .contraseña(passwordEncoder.encode("admin123"))
                    .role(Role.ROLE_ADMIN)
                    .build();
                usuarioRepository.save(admin);

                Usuario user = Usuario.builder()
                    .nombre_usuario("user")
                    .contraseña(passwordEncoder.encode("user123"))
                    .role(Role.ROLE_USER)
                    .build();
                usuarioRepository.save(user);
            }
        };
    }
}
