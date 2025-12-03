package com.cinepluss.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinepluss.demo.model.Licencia;
import com.cinepluss.demo.service.LicenciaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/licencia")
public class LicenciaController {

    private final LicenciaService service;

    public LicenciaController(LicenciaService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener Licencia por id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Licencia Encontrada"),
        @ApiResponse(responseCode = "400", description = "Licencia No Encontrada")
    })

    @GetMapping("/id")
    public Licencia obLicencia(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
