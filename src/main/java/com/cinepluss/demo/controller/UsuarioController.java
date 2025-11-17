package com.cinepluss.demo.controller;

import com.cinepluss.demo.model.Usuario;
import com.cinepluss.demo.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // GET: Listar todos los usuarios
    @Operation(summary = "Listar usuarios")
    @ApiResponses(value = {@ApiResponse( responseCode = "200", description = "Lista de usuarios obtenida correctamente", content = @Content( mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Usuario.class)))),
                            @ApiResponse( responseCode = "400", description = "No Existe una lista de Usuarios")
    })
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // GET: Obtener al Usuario mediante su id
    @Operation(summary = "Obtener usuario por id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "Usuario encontrado", content = @Content(mediaType = "application/json",schema = @Schema(implementation = Usuario.class))),
            @ApiResponse( responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        Usuario usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // POST: Crear un Usuario
    @Operation(summary = "Crear un nuevo usuario")
    @ApiResponses(value = {
        @ApiResponse( responseCode = "201", description = "Usuario creado correctamente", content = @Content( mediaType = "application/json", schema = @Schema(implementation = Usuario.class))),
        @ApiResponse( responseCode = "400", description = "Datos de entrada invalidos")
    })
    @PostMapping
    public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario usuario) {
        Usuario creado = service.crear(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT: Actualizar un Usuario
    @Operation(summary = "Actualizar un usuario existente")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "Usuario actualizado correctamente", content = @Content( mediaType = "application/json", schema = @Schema(implementation = Usuario.class))),
            @ApiResponse( responseCode = "404", description = "Usuario no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        Usuario actualizado = service.actualizar(id, usuario);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE: Eliminar a un Usuario mediante su ID
    @Operation(summary = "Eliminar un usuario por id")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "204", description = "Usuario eliminado correctamente"),
            @ApiResponse( responseCode = "404", description = "Usuario no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}