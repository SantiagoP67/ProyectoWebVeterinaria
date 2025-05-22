package com.veterinaria.demo.servicio;

import java.util.List;

import com.veterinaria.demo.entidad.Medicamento;

public interface MedicamentoService{
    List<Medicamento> obtenerTodosTratamientos();
    Medicamento obtenerMedicamentoPorId(Integer id);
    List<Medicamento> buscarPorNombre(String nombre);

}