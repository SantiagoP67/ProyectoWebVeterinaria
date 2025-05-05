package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Servicio;
import com.veterinaria.demo.entidad.Tratamiento;
import com.veterinaria.demo.servicio.ServicioService;
import com.veterinaria.demo.servicio.TratamientoService;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {
    
    private final ServicioService servicioService;

    @Autowired
    private TratamientoService tratamientoService;

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

    @GetMapping("/por-tratamiento/{id}")
    public ResponseEntity<Servicio> obtenerPorTratamiento(@PathVariable Integer id) {
        Tratamiento tratamiento = tratamientoService.obtenerTratamientoPorId(id);
        if (tratamiento == null) {
            return ResponseEntity.notFound().build();
        }

        Servicio servicio = tratamiento.getServicio();

        if(servicio == null){
            throw new EntityNotFoundException("No hay servicio asociado a este tratamiento");
        }

        return ResponseEntity.ok(servicio);
    }
}