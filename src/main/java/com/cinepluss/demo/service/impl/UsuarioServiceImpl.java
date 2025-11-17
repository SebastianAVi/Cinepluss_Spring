package com.cinepluss.demo.service.impl;

import com.cinepluss.demo.model.Usuario;
import com.cinepluss.demo.repository.UsuarioRepository;
import com.cinepluss.demo.service.UsuarioService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService{
    
    // Importacion del Repositorio de la Entidad Usuario
    private final UsuarioRepository usuarioRepository;

    // Como UsuarioServiceImpl va a implementar la Entidad
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Funciones para Usuario
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));
    }

    @Override
    public Usuario crear(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Ya existe un usuario con email: " + usuario.getEmail());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = buscarPorId(id);

        existente.setNombre_usuario(usuario.getNombre_usuario());
        existente.setEmail(usuario.getEmail());
        existente.setEdad(usuario.getEdad());

        if (usuario.getContraseña() != null && !usuario.getContraseña().isBlank()) {
            existente.setContraseña(usuario.getContraseña());
        }

        return usuarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Usuario existente = buscarPorId(id);
        usuarioRepository.delete(existente);
    }
}
