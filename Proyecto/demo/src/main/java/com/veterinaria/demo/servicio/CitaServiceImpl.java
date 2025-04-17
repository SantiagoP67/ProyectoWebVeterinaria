package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Cita;
import com.veterinaria.demo.repositorio.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    
    private final CitaRepository citaRepository;
    
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }
    
    @Override
    public Cita crearCita(Cita cita) {
        // Validar que la fecha sea futura
        if (cita.getFechaHora().before(new Date())) {
            throw new IllegalArgumentException("La fecha de la cita debe ser futura");
        }
        return citaRepository.save(cita);
    }
    
    @Override
    public List<Cita> obtenerCitasPorCliente(Integer idCliente) {
        return citaRepository.findByMascota_Cliente_IdCliente(idCliente);
    }
    
    @Override
    public List<Cita> obtenerCitasPorSede(String sede) {
        return citaRepository.findBySede(sede);
    }
    
    @Override
    public boolean cancelarCita(Integer idCita) {
        return citaRepository.findById(idCita)
                .map(cita -> {
                    citaRepository.delete(cita);
                    return true;
                })
                .orElse(false);
    }
    
    @Override
    public List<Cita> obtenerCitasPendientes() {
        return citaRepository.findByFechaHoraAfter(new Date());
    }
    
    @Override
    public List<Cita> obtenerCitasPorVeterinario(Integer idVeterinario) {
        return citaRepository.findByVeterinario_IdVeterinario(idVeterinario);
    }
    
    @Override
    public Cita actualizarCita(Cita cita) {
        if (!citaRepository.existsById(cita.getIdCita())) {
            throw new RuntimeException("Cita no encontrada con ID: " + cita.getIdCita());
        }
        return citaRepository.save(cita);
    }
    
    @Override
    public Cita obtenerCitaPorId(Integer idCita) {
        return citaRepository.findById(idCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + idCita));
    }
}