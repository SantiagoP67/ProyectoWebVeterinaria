package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Medicamento;

import java.util.List;

public interface MedicamentoService{
    List<Medicamento> obtenerTodosTratamientos();
    Medicamento obtenerMedicamentoPorId(Integer id);
}