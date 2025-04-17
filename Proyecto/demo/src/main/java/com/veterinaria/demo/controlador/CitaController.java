package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Cita;
import com.veterinaria.demo.servicio.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {
    
    private final CitaService citaService;
    
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }
    
    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        Cita nuevaCita = citaService.crearCita(cita);
        return ResponseEntity.ok(nuevaCita);
    }
    
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Cita>> obtenerCitasPorCliente(@PathVariable Integer idCliente) {
        List<Cita> citas = citaService.obtenerCitasPorCliente(idCliente);
        return ResponseEntity.ok(citas);
    }
    
    @GetMapping("/sede/{sede}")
    public ResponseEntity<List<Cita>> obtenerCitasPorSede(@PathVariable String sede) {
        List<Cita> citas = citaService.obtenerCitasPorSede(sede);
        return ResponseEntity.ok(citas);
    }
    
    @DeleteMapping("/{idCita}")
    public ResponseEntity<Void> cancelarCita(@PathVariable Integer idCita) {
        citaService.cancelarCita(idCita);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/pendientes")
    public ResponseEntity<List<Cita>> obtenerCitasPendientes() {
        List<Cita> citas = citaService.obtenerCitasPendientes();
        return ResponseEntity.ok(citas);
    }
    
    @GetMapping("/veterinario/{idVeterinario}")
    public ResponseEntity<List<Cita>> obtenerCitasPorVeterinario(@PathVariable Integer idVeterinario) {
        List<Cita> citas = citaService.obtenerCitasPorVeterinario(idVeterinario);
        return ResponseEntity.ok(citas);
    }
    
    @PutMapping
    public ResponseEntity<Cita> actualizarCita(@RequestBody Cita cita) {
        Cita citaActualizada = citaService.actualizarCita(cita);
        return ResponseEntity.ok(citaActualizada);
    }
    
    @GetMapping("/{idCita}")
    public ResponseEntity<Cita> obtenerCitaPorId(@PathVariable Integer idCita) {
        Cita cita = citaService.obtenerCitaPorId(idCita);
        return ResponseEntity.ok(cita);
    }
}