package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Tratamiento; 
import com.veterinaria.demo.repositorio.TratamientoRepository; 

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class TratamientoServiceImpl implements TratamientoService{
    @Autowired
    TratamientoRepository tratamientoRepository;

   /*  @Override
    public Tratamiento SearchById(int id) {
        return tratamientoRepository.findById(id).orElse(null);
    }
    @Override
    public List<Tratamiento> SearchAll() {
        return tratamientoRepository.findAll();
    }*/
}