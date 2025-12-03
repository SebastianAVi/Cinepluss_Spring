package com.cinepluss.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinepluss.demo.exception.NotFoundException;
import com.cinepluss.demo.model.Suscripcion;
import com.cinepluss.demo.repository.SuscripcionRepository;
import com.cinepluss.demo.service.SuscripcionService;

@Service
@Transactional
public class SuscripcionServiceImpl implements SuscripcionService{
    
    private final SuscripcionRepository repository;

    public SuscripcionServiceImpl(SuscripcionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Suscripcion buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Suscripcion no encontrada: " + id));
    }
}
