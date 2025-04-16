package com.veterinaria.demo.servicio; 

import com.veterinaria.demo.entidad.Servicio;
import java.util.List;

public interface ServicioService {
    List<Servicio> obtenerTodosServicios();
}