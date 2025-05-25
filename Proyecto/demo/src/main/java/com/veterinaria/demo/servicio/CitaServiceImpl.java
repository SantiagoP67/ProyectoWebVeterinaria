package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Cita;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.entidad.Servicio;
import com.veterinaria.demo.entidad.Veterinario;
import com.veterinaria.demo.repositorio.CitaRepository;
import com.veterinaria.demo.repositorio.ClienteRepository;
import com.veterinaria.demo.repositorio.MascotaRepository;
import com.veterinaria.demo.repositorio.ServicioRepository;
import com.veterinaria.demo.repositorio.VeterinarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;

import java.util.Date;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    
    private final CitaRepository citaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ServicioRepository servicioRepository;
    
    
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }
    
    @Override
    public Cita crearCita(Cita cita) {
        // Validar que la fecha sea futura
        if (cita.getFechaHora().before(new Date())) {
            throw new IllegalArgumentException("La fecha de la cita debe ser futura");
        }

        Veterinario veterinario = veterinarioRepository.findById(cita.getVeterinario().getIdVeterinario())
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado con ID: " + cita.getVeterinario().getIdVeterinario()));

        Mascota mascota = mascotaRepository.findById(cita.getMascota().getIdMascota())
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + cita.getMascota().getIdMascota()));   

        Servicio servicio = servicioRepository.findById(cita.getServicio().getIdServicio())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + cita.getServicio().getIdServicio()));    
                
        cita.setServicio(servicio);
        cita.setVeterinario(veterinario);
        cita.setMascota(mascota);        
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
    public List<Cita> obtenerTodasCitas() {
        return citaRepository.findAll();
    }

    @Override
    public boolean cancelarCita(Integer idCita) {
        return citaRepository.findById(idCita)
                .map(cita -> {
                    cita.setEstado("CANCELADA"); // Asume que tu entidad Cita tiene un campo 'estado'
                    citaRepository.save(cita);
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