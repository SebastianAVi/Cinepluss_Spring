package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nombre invalido")
    @Column(nullable = false)
    private String nombre_usuario;

    @NotBlank(message = "apellido invalido")
    @Column(nullable = false)
    private String ap_usuario;

    @NotBlank(message = "apellido invalido")
    @Column(nullable = false)
    private String am_usuario;

    @NotBlank(message = "edad invalida")
    @Column(nullable = false)
    private int edad;

}