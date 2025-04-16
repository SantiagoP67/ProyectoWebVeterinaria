package com.veterinaria.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.veterinaria.demo.entidad.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    
}