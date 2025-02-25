package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Mascota;
import java.util.List;

public interface MascotaService {
    List<Mascota> obtenerTodasMascotas();
    Mascota obtenerMascotaPorId(Long id);
}