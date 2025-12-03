package com.cinepluss.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinepluss.demo.model.Suscripcion;
import java.util.Optional;


public interface SuscripcionRepository extends JpaRepository <Suscripcion, Long>{
   Optional<Suscripcion> findByTipoSuscripcion (String tipoSuscripcion);
}
