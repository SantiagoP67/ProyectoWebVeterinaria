package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tratamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTratamiento;
    @Column(nullable = false)
    private String codigo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "idVeterinario", nullable = true)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.SET_NULL)
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "idMascota", nullable = true)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.SET_NULL)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = true)
    @org.hibernate.annotations.OnDelete(action = org.hibernate.annotations.OnDeleteAction.SET_NULL)
    private Servicio servicio;

    @OneToMany(mappedBy = "tratamiento", cascade = CascadeType.ALL)
    private List<TratamientoMedicamento> tratamientoMedicamentos;
}
