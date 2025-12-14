package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Table(name = "pelicula")
@Data
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "La categoría es obligatoria")
    @Column(nullable = false)
    private String categoria;

    @Positive(message = "El precio debe ser un número positivo")
    @Column(nullable = false)
    private Integer precio;

    @NotBlank(message = "La sinopsis es obligatoria")
    @Column(nullable = false)
    private String sinopsis;

    private String imagen;
}