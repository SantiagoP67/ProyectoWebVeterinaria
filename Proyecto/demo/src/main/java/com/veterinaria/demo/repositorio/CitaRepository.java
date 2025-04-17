package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    
    List<Cita> findByMascota_Cliente_IdCliente(Integer idCliente);
    
    List<Cita> findBySede(String sede);
    
    List<Cita> findByFechaHoraAfter(Date fecha);
    
    List<Cita> findByVeterinario_IdVeterinario(Integer idVeterinario);
    
    @Query("SELECT c FROM Cita c WHERE c.fechaHora BETWEEN :inicio AND :fin")
    List<Cita> findCitasEntreFechas(Date inicio, Date fin);
    
    @Query("SELECT c FROM Cita c WHERE c.sede = :sede AND c.fechaHora BETWEEN :inicio AND :fin")
    List<Cita> findCitasPorSedeYFecha(String sede, Date inicio, Date fin);
}