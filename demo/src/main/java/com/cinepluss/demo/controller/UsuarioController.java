package com.cinepluss.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {


    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    
    @operation(summary = "Listas Usuarios")
    @ApiResponses({
        @@ApiResponses(responseCode = "200". descripcion = "ok",
        content = @content(Array = @ArraySchema(schema = @schema(implemetatiom = Usuario.class)))
    })

    @GetMapping
    public 

}