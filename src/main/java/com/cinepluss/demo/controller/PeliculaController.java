package com.cinepluss.demo.controller;

import com.cinepluss.demo.model.Pelicula;
import com.cinepluss.demo.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar Peliculas", descripcion = "Devuelve todas las peliculas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", descripcion = "OK",
        content = @Content(array = @ArraySchema(schema = @Schema(implemetation = Pelicula.class))))
    })

    @GetMapping
    public List<Pelicula> listar() {
        return service.listar();
    }

    @Operation(summary = "Obtener por id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", descripcion = "Peliculas Encontradas"),
        @ApiResponse(responseCode = "400", descripcion = "No Encontradas")
    })

    @GetMapping("/id")
    public Pelicula obPelicula(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Obtenr por texto en el titulo de la Pelicula")
    @GetMapping("/search")
    public List<Pelicula> buscarTitulo(@RequestParam String q) {
        return service.buscarPorTitulo(q);
    }

    @Operation(summary = "Crear Pelicula")
    @ApiResponse(responseCode = "201", descripcion = "Creada")
    @PostMapping
    public ResponseEntity<Pelicula> crearPelicula(@Valid @RequestBody Pelicula pelicula) {
        Pelicula creada = service.crear(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @Operation(summary = "Actualizar Pelicula")
    @PutMapping("/id")
    public Pelicula acPelicula(@PathVariable Long id, @Valid @RequestBody Pelicula pelicula) {
        return service.actualizar(id, pelicula);
    }

    @Operation(summary = "Eliminar Pelicula")
    @ApiResponse(responseCode = "204", descripcion = "Eliminada")
    @DeleteMapping("/id")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
