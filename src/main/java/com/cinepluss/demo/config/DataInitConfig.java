package com.cinepluss.demo.config;

import com.cinepluss.demo.model.Role;
import com.cinepluss.demo.model.Usuario;
import com.cinepluss.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitConfig implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            Usuario admin = Usuario.builder()
                    .nombre("Administrador")
                    .apUsuario("Sistema")
                    .email("admin@cineplus.cl")          // <- email válido
                    .contraseña(passwordEncoder.encode("admin123"))
                    .edad(30)                            // <- edad válida
                    .role(Role.ROLE_ADMIN)
                    .build();

            Usuario user = Usuario.builder()
                    .nombre("Usuario")
                    .apUsuario("Demo")
                    .email("user@cineplus.cl")           // <- email válido
                    .contraseña(passwordEncoder.encode("user123"))
                    .edad(25)                            // <- edad válida
                    .role(Role.ROLE_USER)
                    .build();

            usuarioRepository.save(admin);
            usuarioRepository.save(user);
        }
    }
}
