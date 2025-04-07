package com.veterinaria.demo.entidad;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(nullable = true)
    private Integer edad;
    @Column(nullable = true)
    private Float peso;
    @Column(nullable = true)
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