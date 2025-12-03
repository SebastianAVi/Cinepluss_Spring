package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "entrada")
@Data
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Se requiere de un codigo de entrada valido")
    @Column
    private String codigo;

    @NotBlank(message = "Se requiere un valor de la entrada valido")
    @Column(nullable = false)
    private int valorEntrada;

}