package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


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

    @Column(nullable = false)
    private String ap_usuario;

    @NotBlank(message = "email invalido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "contraseña invalida")
    @Column(nullable = false)
    private String contraseña;

    @NotBlank(message = "edad invalida")
    @Column(nullable = false)
    private int edad;

}