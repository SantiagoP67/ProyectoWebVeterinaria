package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.repositorio.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<Mascota> obtenerTodasMascotas() {
        return mascotaRepository.obtenerTodas();
    }

    @Override
    public Mascota obtenerMascotaPorId(Long id) {
        return mascotaRepository.obtenerPorId(id).orElse(null);
    }
}