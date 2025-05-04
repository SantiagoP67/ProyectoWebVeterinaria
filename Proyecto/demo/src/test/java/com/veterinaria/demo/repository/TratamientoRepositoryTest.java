package com.veterinaria.demo.repository;

import com.veterinaria.demo.entidad.*;
import com.veterinaria.demo.repositorio.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TratamientoRepositoryTest {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void TratamientoRepository_save_Tratamiento() {
        // Arrange
        Cliente cliente = new Cliente(
                null,
                "Juan Pérez",
                "juan@example.com",
                "3216549870",
                "foto.jpg",
                "123456789",
                "juanp",
                "1234",
                Collections.emptyList(),
                Collections.emptyList()
        );
        cliente = clienteRepository.save(cliente);

        Mascota mascota = new Mascota(
                null,
                "Firulais",
                "Labrador",
                5,
                20.0f,
                "Ninguna",
                "mascota.jpg",
                new Date(),
                new Date(),
                null,
                1,
                cliente
        );
        mascota = mascotaRepository.save(mascota);

        Veterinario veterinario = new Veterinario(
                null,
                "Dra. Laura",
                "987654321",
                "General",
                "fotoVet.jpg",
                "Sede A",
                1,
                0,
                "laura.vet",
                "pass",
                Collections.emptyList(),
                Collections.emptyList()
        );
        veterinario = veterinarioRepository.save(veterinario);

        Servicio servicio = new Servicio(
                null,
                "Consulta General",
                "Chequeo médico completo",
                60.0f,
                "front.jpg",
                "back.jpg",
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        servicio = servicioRepository.save(servicio);

        Tratamiento tratamiento = new Tratamiento(
                null,
                "TRAT-001",
                new Date(),
                "Desparasitación y control de peso",
                veterinario,
                mascota,
                servicio,
                Collections.emptyList()
        );

        // Act
        Tratamiento guardado = tratamientoRepository.save(tratamiento);

        // Assert
        assertThat(guardado.getIdTratamiento()).isNotNull();
        assertThat(guardado.getCodigo()).isEqualTo("TRAT-001");
        assertThat(guardado.getMascota().getNombre()).isEqualTo("Firulais");
    }
}