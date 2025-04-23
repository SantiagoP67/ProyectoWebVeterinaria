package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Tratamiento;

import java.util.List;

public interface TratamientoService{
    List<Tratamiento> obtenerTodosTratamientos();
    Tratamiento obtenerTratamientoPorId(Integer id);
}