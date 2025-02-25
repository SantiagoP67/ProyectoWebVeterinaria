package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Mascota;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MascotaRepository {
    private final List<Mascota> mascotas = new ArrayList<>();

    public MascotaRepository() {
        // Agregar 10 mascotas de prueba
        mascotas.add(new Mascota(1L, "Firulais", "Labrador", 5, 25.3f, "Ninguna", "foto1.jpg", true));
        mascotas.add(new Mascota(2L, "Max", "Pastor Alemán", 3, 30.2f, "Alergia", "foto2.jpg", true));
        mascotas.add(new Mascota(3L, "Luna", "Beagle", 4, 15.6f, "Otitis", "foto3.jpg", true));
        mascotas.add(new Mascota(4L, "Rocky", "Bulldog", 6, 28.1f, "Artritis", "foto4.jpg", true));
        mascotas.add(new Mascota(5L, "Toby", "Golden Retriever", 2, 22.5f, "Ninguna", "foto5.jpg", true));
        mascotas.add(new Mascota(6L, "Bruno", "Dóberman", 5, 35.7f, "Hipotiroidismo", "foto6.jpg", true));
        mascotas.add(new Mascota(7L, "Nala", "Poodle", 7, 10.2f, "Ceguera parcial", "foto7.jpg", true));
        mascotas.add(new Mascota(8L, "Simba", "Chihuahua", 1, 3.1f, "Ninguna", "foto8.jpg", true));
        mascotas.add(new Mascota(9L, "Daisy", "Husky Siberiano", 4, 27.3f, "Sordera", "foto9.jpg", true));
        mascotas.add(new Mascota(10L, "Bobby", "Boxer", 6, 29.0f, "Cardiopatía", "foto10.jpg", true));
    }

    public List<Mascota> obtenerTodas() {
        return new ArrayList<>(mascotas);
    }

    public Optional<Mascota> obtenerPorId(Long id) {
        return mascotas.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
}


