package com.veterinaria.demo.servicio;

import java.util.Collection;

import com.veterinaria.demo.entidad.Medicamento; 

public interface MedicamentoService{

    public Medicamento SearchById(int id);
    
    public Collection<Medicamento> SearchAll(); 

}

