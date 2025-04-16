package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "testimonio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Testimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTestimonio;
    
    @Column(nullable = false)
    private String texto;
    
    @Column(nullable = false)
    private Integer calificacion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private Servicio servicio;
}