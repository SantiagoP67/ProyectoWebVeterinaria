package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "mascota")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String raza;
    @Column(nullable = false)
    private Integer edad;
    @Column(nullable = false)
    private Float peso;
    @Column(nullable = false)
    private String enfermedad;
    @Column(nullable = false)
    private String foto;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaNacimiento;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaIngreso;

    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Column(nullable = true)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;
}