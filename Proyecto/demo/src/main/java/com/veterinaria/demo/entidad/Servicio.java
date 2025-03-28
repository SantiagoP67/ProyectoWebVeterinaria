package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Float precioBase;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Testimonio> testimonios;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamientos;

    @ManyToMany
    @JoinTable(
            name = "servicioFactura",
            joinColumns = @JoinColumn(name = "idServicio"),
            inverseJoinColumns = @JoinColumn(name = "idFactura")
    )
    private List<Factura> facturas;
}