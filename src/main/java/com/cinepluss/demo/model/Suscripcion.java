package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "suscripcion")
@Data
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Monto de suscripcion invalido")
    @Column(nullable = false)
    private int valorSuscripcion;

    @NotBlank(message = "tipo de suscripcion invalido")
    @Column(nullable = false)
    private String tipoSuscripcion;

    
}