package com.cinepluss.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinepluss.demo.exception.NotFoundException;
import com.cinepluss.demo.model.Entrada;
import com.cinepluss.demo.repository.EntradaRepository;
import com.cinepluss.demo.service.EntradaService;

@Service
@Transactional
public class EntradaServiceImpl implements EntradaService {
    
    private final EntradaRepository repositorio;
    
    public EntradaServiceImpl(EntradaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public Entrada buscarPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Licencia no encontrada: " + id));
    }
}
