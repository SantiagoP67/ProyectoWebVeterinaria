package com.veterinaria.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.demo.entidad.Cliente; 

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByCedula(String cedula);
}