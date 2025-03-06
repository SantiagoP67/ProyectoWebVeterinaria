package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Mascota;
import java.util.List;

public interface MascotaService {
    List<Mascota> obtenerTodasMascotas();
    Mascota obtenerMascotaPorId(Integer id);
    List<Mascota> obtenerMascotasPorCliente(Integer idCliente);
    Mascota crearMascota(Mascota mascota, String cedula);
    Mascota actualizarMascota(Integer id, Mascota mascota);
    void eliminarMascota(Integer id);
}
