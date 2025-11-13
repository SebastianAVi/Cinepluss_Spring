package com.cinepluss.demo.controller;

import com.cinepluss.demo.model.Entrada;

@RestController
@RequestMapping("/api/entrada")
public class EntradaController {

    private final EntradaService service;

    public EntradaController(EntradaService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener Entrada por id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", descripcion = "Entrada Encontrada"),
        @ApiResponse(responseCode = "400", descripcion = "Entrada No Encontrada")
    })

    @GetMapping("/id")
    public Entrada obEntrada(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
