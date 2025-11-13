package com.cinepluss.demo.controller;

import com.cinepluss.demo.model.Licencia;

@RestController
@RequestMapping("/id/licencia")
public class LicenciaController {

    private final LicenciaService service;

    public LicenciaController(LicenciaService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener Licencia por id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", descripcion = "Licencia Encontrada"),
        @ApiResponse(responseCode = "400", descripcion = "Licencia No Encontrada")
    })

    @GetMapping("/id")
    public Licencia obLicencia(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
