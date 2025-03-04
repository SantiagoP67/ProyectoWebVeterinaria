package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tratamiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTratamiento;

    private String codigo;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String detalles;

    @ManyToOne
    @JoinColumn(name = "idVeterinario", nullable = false)
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "idMascota", nullable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private Servicio servicio;

    @OneToMany(mappedBy = "tratamiento", cascade = CascadeType.ALL)
    private List<TratamientoMedicamento> tratamientoMedicamentos;
}