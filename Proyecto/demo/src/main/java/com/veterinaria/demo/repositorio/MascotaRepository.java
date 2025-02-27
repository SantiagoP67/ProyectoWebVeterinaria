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
        mascotas.add(new Mascota(1L, "Firulais", "Labrador", 5, 25.3f, "Ninguna", "https://images.wagwalkingweb.com/media/daily_wag/blog_articles/hero/1670938235.1927571/fun-facts-about-labrador-retrievers.jpg", true));
        mascotas.add(new Mascota(2L, "Max", "Pastor Alemán", 3, 30.2f, "Alergia", "https://www.zooplus.es/magazine/wp-content/uploads/2019/03/deutscher-sch%C3%A4ferhund.jpg", true));
        mascotas.add(new Mascota(3L, "Luna", "Beagle", 4, 15.6f, "Otitis", "https://upload.wikimedia.org/wikipedia/commons/b/b6/Shemsu_Sotis_Perun.jpg", true));
        mascotas.add(new Mascota(4L, "Rocky", "Bulldog", 6, 28.1f, "Artritis", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Bulldog_inglese.jpg/800px-Bulldog_inglese.jpg", true));
        mascotas.add(new Mascota(5L, "Toby", "Golden Retriever", 2, 22.5f, "Ninguna", "https://heronscrossing.vet/wp-content/uploads/Golden-Retriever.jpg", true));
        mascotas.add(new Mascota(6L, "Bruno", "Dóberman", 5, 35.7f, "Hipotiroidismo", "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/XQ5OB4SRZ5B5LD7S7QIRCLHTVY.jpg", true));
        mascotas.add(new Mascota(7L, "Nala", "Poodle", 7, 10.2f, "Ceguera parcial", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzbKJy-vy1rESq8YuAABrlJC__zTpmSveuQQ&s", true));
        mascotas.add(new Mascota(8L, "Simba", "Chihuahua", 1, 3.1f, "Ninguna", "https://www.purina.es/sites/default/files/2021-02/BREED%20Hero_0034_chihuahua_smooth.jpg", true));
        mascotas.add(new Mascota(9L, "Daisy", "Husky Siberiano", 4, 27.3f, "Sordera", "https://foreverhusky.org/wp-content/uploads/2024/05/Malamute-vs-Husky-.jpg", true));
        mascotas.add(new Mascota(10L, "Bobby", "Boxer", 6, 29.0f, "Cardiopatía", "https://cdn.britannica.com/46/233846-050-8D30A43B/Boxer-dog.jpg", true));
    }

    public List<Mascota> obtenerTodas() {
        return new ArrayList<>(mascotas);
    }

    public Optional<Mascota> obtenerPorId(Long id) {
        return mascotas.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
}


