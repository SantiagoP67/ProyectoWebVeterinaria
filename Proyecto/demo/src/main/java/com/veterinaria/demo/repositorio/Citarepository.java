package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Citarepository extends JpaRepository<Cita, Integer> {

}
