package com.cinepluss.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    
    @Operation(summary = "Listas Usuarios")
    @ApiResponses({
        @ApiResponse(responseCode = "200", descripcion = "OK",
        content = @content(Array = @ArraySchema(schema = @schema(implemetation = Usuario.class))))
    })

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @Operation(summary = "Obtener por id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", descripcion = "Usuario Encontrado"),
        @ApiResponse(responseCode = "400", descripcion = "No Encontrado")
    })

    @GetMapping("/id")
    public User obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}