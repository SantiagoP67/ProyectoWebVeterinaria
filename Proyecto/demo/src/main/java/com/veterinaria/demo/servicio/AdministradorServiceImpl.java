package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Administrador ;
import com.veterinaria.demo.repositorio.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class AdministradorServiceImpl implements AdministradorService{
    @Autowired
    AdministradorRepository administradorRepository;

   /*  @Override
    public Administrador SearchById(int id) {
        return administradorRepository.findById(id).orElse(null);
    }
  
}