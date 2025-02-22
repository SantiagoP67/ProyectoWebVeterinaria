package com.veterinaria.demo.servicio;

import java.util.Collection;

import com.veterinaria.demo.entidad.Tratamiento;

public interface TratamientoService{
    public Tratamiento SearchById(int id); 

    public Collection<Tratamiento> SearchAll(); 
}