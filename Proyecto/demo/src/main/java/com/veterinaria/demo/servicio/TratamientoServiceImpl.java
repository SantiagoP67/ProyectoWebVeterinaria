package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Tratamiento;
import com.veterinaria.demo.repositorio.TratamientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TratamientoServiceImpl implements TratamientoService{
    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> obtenerTodosTratamientos() {
        return tratamientoRepository.findAll();
    }

    @Override
    public Tratamiento obtenerTratamientoPorId(Integer id) {
        return tratamientoRepository.findById(id).orElse(null);
    }
}