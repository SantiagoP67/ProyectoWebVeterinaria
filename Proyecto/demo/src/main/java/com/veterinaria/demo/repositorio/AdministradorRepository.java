package com.veterinaria.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.demo.entidad.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    /*public Administrador findById(int id){
        return data.get(id);
    }*/

}