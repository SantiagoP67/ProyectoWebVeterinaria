package com.veterinaria.demo.dto;

import lombok.Data;

@Data
public class MedicamentoCantidadDTO {
    private Integer idMedicamento;
    private Integer cantidad;

    public MedicamentoCantidadDTO(Integer idMedicamento, Integer cantidad) {
        this.idMedicamento = idMedicamento;
        this.cantidad = cantidad;
    }

    public MedicamentoCantidadDTO() {
    // Constructor vacío requerido por frameworks como Spring o Jackson
    }

}
