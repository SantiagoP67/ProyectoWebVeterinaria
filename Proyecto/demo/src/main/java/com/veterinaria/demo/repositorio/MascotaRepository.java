package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
    List<Mascota> findByClienteIdCliente(Integer idCliente);
}
