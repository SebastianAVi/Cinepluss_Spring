package com.cinepluss.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinepluss.demo.model.Entrada;
import java.util.Optional;


@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long>{
    Optional<Entrada> findByCodigo(String codigo);

}
