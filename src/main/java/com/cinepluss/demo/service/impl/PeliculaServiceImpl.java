package com.cinepluss.demo.service.impl;

import com.cinepluss.demo.exception.NotFoundException;
import com.cinepluss.demo.model.Pelicula;
import com.cinepluss.demo.repository.PeliculaRepository;
import com.cinepluss.demo.service.PeliculaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository repo;

    public PeliculaServiceImpl(PeliculaRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> listar() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Pelicula no encontrada: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> buscarPorTitulo(String q) {
        return repo.findByTituloContainingIgnoreCase(q);
    }

    @Override
    public Pelicula crear(Pelicula Pelicula) {
        return repo.save(Pelicula);
    }

    @Override
    public Pelicula actualizar(Long id, Pelicula Pelicula) {
        Pelicula actual = buscarPorId(id);
        actual.setTitulo(Pelicula.getTitulo());
        
        return repo.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        Pelicula actual = buscarPorId(id);
        repo.delete(actual);
    }
}
