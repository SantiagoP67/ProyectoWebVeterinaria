package com.veterinaria.demo.servicio;

import java.util.List;
import com.veterinaria.demo.entidad.Veterinario;

public interface VeterinarioService {
    List<Veterinario> obtenerTodosVeterinarios();
    Veterinario obtenerVeterinarioPorId(Integer id);
    Veterinario crearVeterinario(Veterinario veterinario);
    Veterinario editarVeterinario(Integer id, Veterinario veterinario);
    void eliminarVeterinario(Integer id);
    Veterinario validarVeterinario(String username, String password);
}
