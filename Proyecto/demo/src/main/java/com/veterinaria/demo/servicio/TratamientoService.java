package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Tratamiento;

import java.util.List;
import java.util.Map;

public interface TratamientoService{
    List<Tratamiento> obtenerTodosTratamientos();
    Tratamiento obtenerTratamientoPorId(Integer id);
    long contarTratamientosUltimos30Dias();
    List<Tratamiento> obtenerTratamientosUltimos30Dias();
    Map<String, Integer> obtenerMedicamentosMasUsadosUltimos30Dias();
    List<Map<String, Object>> obtenerTop3MedicamentosMasVendidos();
}