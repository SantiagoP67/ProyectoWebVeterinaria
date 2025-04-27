package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Servicio;
import com.veterinaria.demo.servicio.ServicioService;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {
    
    private final ServicioService servicioService;
    
    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }
    
    @GetMapping
    public ResponseEntity<List<Servicio>> obtenerTodosServicios() {
        List<Servicio> servicios = servicioService.obtenerTodosServicios();
        return ResponseEntity.ok(servicios);
    }
    
    @GetMapping("/ventas-totales")
    public ResponseEntity<BigDecimal> obtenerVentasTotales() {
        BigDecimal ventasTotales = servicioService.calcularVentasTotales();
        return ResponseEntity.ok(ventasTotales);
    }
    
    @GetMapping("/ganancias-totales")
    public ResponseEntity<BigDecimal> obtenerGananciasTotales() {
        BigDecimal gananciasTotales = servicioService.calcularGananciasTotales();
        return ResponseEntity.ok(gananciasTotales);
    }
}