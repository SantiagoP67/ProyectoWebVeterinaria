package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Servicio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    List<Servicio> findAllByOrderByNombreAsc();
}