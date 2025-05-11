package com.veterinaria.demo.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedicamento;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    @Builder.Default
    private Float precioCompra = 0.0f;
    
    @Column(nullable = false)
    @Builder.Default
    private Float precioVenta = 0.0f;
    
    @Column(nullable = false)
    @Builder.Default
    private Integer unidadesDisponibles = 0;
    
    @Column(nullable = false)
    @Builder.Default
    private Integer unidadesVendidas = 0;

    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TratamientoMedicamento> tratamientoMedicamentos;

    @OneToMany(mappedBy = "medicamento")
    private List<FacturaMedicamento> facturaMedicamentos;

    public Medicamento(String nombre, Float precioCompra, Float precioVenta, Integer unidadesDisponibles, Integer unidadesVendidas) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }
}