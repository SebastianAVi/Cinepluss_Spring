package com.cinepluss.demo.config;

import com.cinepluss.demo.model.Pelicula;
import com.cinepluss.demo.model.Role;
import com.cinepluss.demo.model.Usuario;
import com.cinepluss.demo.repository.PeliculaRepository;
import com.cinepluss.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataInitConfig implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PeliculaRepository peliculaRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // 1) Seed usuarios
        if (usuarioRepository.count() == 0) {
            Usuario admin = Usuario.builder()
                    .nombre("Administrador")
                    .apUsuario("Sistema")
                    .email("admin@cineplus.cl")
                    .contraseña(passwordEncoder.encode("admin123"))
                    .edad(30)
                    .role(Role.ROLE_ADMIN)
                    .build();

            Usuario user = Usuario.builder()
                    .nombre("Usuario")
                    .apUsuario("Demo")
                    .email("user@cineplus.cl")
                    .contraseña(passwordEncoder.encode("user123"))
                    .edad(25)
                    .role(Role.ROLE_USER)
                    .build();

            usuarioRepository.save(admin);
            usuarioRepository.save(user);
        }

        // 2) Seed peliculas (equivalente al mock.js)
        if (peliculaRepository.count() == 0) {
            List<Pelicula> peliculas = List.of(
                    buildPelicula("Atlantis Live Action", "Live Action", 7200,
                            "Una aventura épica en el mundo perdido de Atlantis, ahora en versión live action.",
                            "https://i.imgur.com/o6kyp0N.jpeg"),

                    buildPelicula("El Gigante de Acero Live Action", "Live Action", 6500,
                            "Un gigante de acero llega a la Tierra y crea un vínculo inesperado con un niño.",
                            "https://i.imgur.com/pnHskUv.png"),

                    buildPelicula("Jorge El Hombre Mono", "Acción", 3500,
                            "Jorge se enfrenta a desafíos salvajes y rescata a sus amigos en la jungla.",
                            "https://i.imgur.com/jDyxNBV.png"),

                    buildPelicula("El Causa Motosierra", "Animación", 6900,
                            "Animación frenética y humor oscuro: el causa llega con su motosierra.",
                            "https://i.imgur.com/MSWbl8x.jpeg"),

                    buildPelicula("El viejo del saco", "Terror", 4750,
                            "Cuando cae la noche, nadie está a salvo: el viejo del saco vuelve a aparecer.",
                            "https://i.imgur.com/YmTit4x.png"),

                    buildPelicula("La Monja", "Terror", 2100,
                            "Un secreto del convento desata una presencia aterradora imposible de detener.",
                            "https://i.imgur.com/tszJoVm.png"),

                    buildPelicula("Volviendo al Presente", "Documental", 10000,
                            "Un documental sobre cómo el pasado explica el presente y sus decisiones.",
                            "https://i.imgur.com/1BbezVt.jpeg"),

                    buildPelicula("El PAPA", "Comedia", 2510,
                            "Comedia ligera de enredos familiares que nadie vio venir.",
                            "https://i.imgur.com/uJ1xoRn.png"),

                    buildPelicula("Choc-Man", "Acción", 7000,
                            "Choc-Man lucha por salvar la ciudad usando su poder… y mucho ingenio.",
                            "https://i.imgur.com/hOefwrC.png")
            );

            peliculaRepository.saveAll(peliculas);
        }
    }

    private Pelicula buildPelicula(String titulo, String categoria, Integer precio, String sinopsis, String imagen) {
        Pelicula p = new Pelicula();
        p.setTitulo(titulo);
        p.setCategoria(categoria);
        p.setPrecio(precio);
        p.setSinopsis(sinopsis);
        p.setImagen(imagen);
        return p;
    }
}
