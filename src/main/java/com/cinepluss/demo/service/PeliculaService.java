package com.cinepluss.demo.service;

import com.cinepluss.demo.model.Pelicula;
import java.util.List;

public interface PeliculaService {
    List<Peliculas> listar();
    Pelicula buscarPorId(Long id);
    List<Pelicula> buscarPorTitulo(String q);
    Pelicula crear(Pelicula Pelicula);
    Pelicula actualizar(Long id, Pelicula Pelicula);
    void eliminar(Long id);
}
