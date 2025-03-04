package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "factura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private Integer idFactura;

    @Column(name = "fecha", nullable = false)
    private java.sql.Timestamp fecha;

    @Column(name = "total", nullable = false)
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