package com.veterinaria.demo.servicio;

import java.util.List;

import com.veterinaria.demo.entidad.Mascota;

public interface MascotaService {
    List<Mascota> obtenerTodasMascotas();
    Mascota obtenerMascotaPorId(Integer id);
    List<Mascota> obtenerMascotasPorCliente(Integer idCliente);
    Mascota crearMascota(Mascota mascota, Integer idCliente);
    Mascota actualizarMascota(Integer id, Mascota mascota);
    void eliminarMascota(Integer id);
    void cambiarEstado(Integer id, Mascota mascota);
}
