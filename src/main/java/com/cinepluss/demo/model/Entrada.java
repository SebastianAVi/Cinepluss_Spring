package com.cinepluss.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "entrada")
@Data
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Se requiere un valor de la entrada valido")
    @Column(nullable = false)
    private int valor_entrada;

}