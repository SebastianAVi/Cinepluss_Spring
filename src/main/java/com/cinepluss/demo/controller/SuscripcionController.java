package com.cinepluss.demo.controller;

import com.cinepluss.demo.model.Suscripcion;
import com.cinepluss.demo.service.SuscripcionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suscripcion")
public class SuscripcionController {
    
    private final SuscripcionService service;

    public SuscripcionController(SuscripcionService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener suscripciones por id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Suscripcion Encontrada"),
        @ApiResponse(responseCode = "400", description = "No Encontrada")
    })

    @GetMapping("/id")
    public Suscripcion obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
