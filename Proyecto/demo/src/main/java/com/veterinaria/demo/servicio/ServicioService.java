package com.veterinaria.demo.servicio; 

import com.veterinaria.demo.entidad.Servicio;

import java.math.BigDecimal;
import java.util.List;

public interface ServicioService {
    List<Servicio> obtenerTodosServicios();
    BigDecimal calcularVentasTotales();
    BigDecimal calcularGananciasTotales();
}