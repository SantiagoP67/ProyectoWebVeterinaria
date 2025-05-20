package com.veterinaria.demo.dto;

import lombok.Data;

@Data
public class MedicamentoDTO {
    private Integer idMedicamento;
    private String nombre;
    private Float precioCompra;
    private Float precioVenta;
    private Integer unidadesDisponibles;
    private Integer unidadesVendidas;
}