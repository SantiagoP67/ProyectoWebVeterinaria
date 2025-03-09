package com.veterinaria.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.entidad.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
 
    @Query("SELECT t.mascota FROM Tratamiento t WHERE t.veterinario.id = :idVeterinario")
    List<Mascota> findMascotasByVeterinarioId(@Param("idVeterinario") Integer idVeterinario);
}    