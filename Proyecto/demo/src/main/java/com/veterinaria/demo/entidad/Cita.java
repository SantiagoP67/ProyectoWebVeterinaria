package com.veterinaria.demo.entidad;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    private String sede;

    @ManyToOne
    @JoinColumn(name = "idMascota", nullable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "idVeterinario", nullable = false)
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private Servicio servicio;
}