package com.cinepluss.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinepluss.demo.exception.NotFoundException;
import com.cinepluss.demo.model.Licencia;
import com.cinepluss.demo.repository.LicenciaRepository;
import com.cinepluss.demo.service.LicenciaService;

@Service
@Transactional
public class LicenciaServiceImpl implements LicenciaService{

    private final LicenciaRepository repository;

    public LicenciaServiceImpl(LicenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Licencia buscarPorId (Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Licencia no encontrada: " + id));
    }
}
