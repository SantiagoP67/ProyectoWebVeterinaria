package com.veterinaria.demo.repositorio;

import com.veterinaria.demo.entidad.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
    Veterinario findByCedula(String cedula);
    Veterinario findByNombreUsuarioAndContrasena(String nombreUsuario,String contrasena);
}