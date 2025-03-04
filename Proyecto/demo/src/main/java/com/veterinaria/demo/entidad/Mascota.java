package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "mascota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;

    private String nombre;
    private String raza;
    private Integer edad;
    private Float peso;
    private String enfermedad;
    private String foto;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;
}