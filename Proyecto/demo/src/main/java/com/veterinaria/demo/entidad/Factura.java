package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(nullable = false)
    private java.sql.Timestamp fecha;

    @Column(nullable = false)
    private Float total;

    @ManyToMany
    @JoinTable(
            name = "facturaMetodoPago",
            joinColumns = @JoinColumn(name = "idFactura"),
            inverseJoinColumns = @JoinColumn(name = "idMetodoPago")
    )
    private List<MetodoPago> metodosPago;

    @ManyToMany(mappedBy = "facturas")
    private List<Servicio> servicios;
}