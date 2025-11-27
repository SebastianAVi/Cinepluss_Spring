package com.cinepluss.demo.controller;

import com.cinepluss.demo.model.Entrada;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinepluss.demo.service.EntradaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/entrada")
public class EntradaController {

    private final EntradaService service;

    public EntradaController(EntradaService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener Entrada por id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Entrada Encontrada"),
        @ApiResponse(responseCode = "400", description = "Entrada No Encontrada")
    })

    @GetMapping("/id")
    public Entrada obEntrada(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
