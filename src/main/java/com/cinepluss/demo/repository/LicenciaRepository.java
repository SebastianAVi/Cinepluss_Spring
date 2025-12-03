package com.cinepluss.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinepluss.demo.model.Licencia;

@Repository
public interface LicenciaRepository  extends JpaRepository<Licencia, Long>{
    Optional<Licencia> findByLicencia (String licencia);
}
