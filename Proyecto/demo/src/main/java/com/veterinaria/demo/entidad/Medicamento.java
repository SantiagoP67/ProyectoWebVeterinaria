package com.veterinaria.demo.entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedicamento;

    private String nombre;
    private Float precioCompra;
    private Float precioVenta;
    private Integer unidadesDisponibles;
    private Integer unidadesVendidas;

    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
    private List<TratamientoMedicamento> tratamientoMedicamentos;
}