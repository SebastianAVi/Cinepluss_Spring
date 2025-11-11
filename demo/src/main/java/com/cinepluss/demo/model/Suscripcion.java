package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "suscripcion")
@Data
public class suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Monto de suscripcion invalido")
    @Column(nullable = false)
    private int valor_suscripcion;

    @NotBlank(message = "tipo de suscripcion invalido")
    @Column(nullable = false)
    private String tipo_suscripcion;

}