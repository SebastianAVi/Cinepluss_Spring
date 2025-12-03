package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "usuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nombre invalido")
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apUsuario;

    @NotBlank(message = "email invalido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "contraseña invalida")
    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private int edad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}