package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, String> {
}
