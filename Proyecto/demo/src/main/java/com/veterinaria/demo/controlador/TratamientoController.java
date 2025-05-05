package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.*;
import com.veterinaria.demo.repositorio.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.veterinaria.demo.servicio.TratamientoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.veterinaria.demo.servicio.MascotaService;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController{


    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    
    @GetMapping
    public List<Tratamiento> mostrarTratamientos() {
        return tratamientoService.obtenerTodosTratamientos();
    }

    @GetMapping("/{id}")
    public Tratamiento detalleTratamiento(@PathVariable Integer id) {
        return tratamientoService.obtenerTratamientoPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<Tratamiento> crearTratamiento(
            @RequestBody Tratamiento tratamiento,
            @RequestParam Integer idMascota,
            @RequestParam Integer idServicio,
            @RequestParam(required = false) Integer idVeterinario,
            @RequestParam List<Integer> idsMedicamentos) {
    
        Tratamiento nuevoTratamiento = tratamientoService.crearTratamiento(tratamiento, idMascota, idServicio, idVeterinario, idsMedicamentos);
        return ResponseEntity.ok(nuevoTratamiento);
    }
    

    @PutMapping("/editar/{id}")
    public ResponseEntity<Tratamiento> editarTratamiento(
            @PathVariable Integer id,
            @RequestBody Tratamiento tratamientoActualizado,
            @RequestParam Integer idMascota,
            @RequestParam Integer idServicio,
            @RequestParam(required = false) Integer idVeterinario,
            @RequestParam List<Integer> idsMedicamentos) {
    
        Tratamiento actualizado = tratamientoService.editarTratamiento(id, tratamientoActualizado, idMascota, idServicio, idVeterinario, idsMedicamentos);
        return ResponseEntity.ok(actualizado);
    }
    

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTratamiento(@PathVariable Integer id) {
        tratamientoService.eliminarTratamientoPorId(id);
        return ResponseEntity.ok("Tratamiento eliminado correctamente");
    }

    @GetMapping("/por-mascota/{idMascota}")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosPorMascota(@PathVariable Integer idMascota) {
        Mascota mascota = mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        List<Tratamiento> tratamientos = tratamientoRepository.findByMascota(mascota);
        return ResponseEntity.ok(tratamientos);
    }
    

    @GetMapping("/cantidad-ultimos-30-dias")
    public ResponseEntity<Long> contarTratamientosUltimos30Dias() {
        Long cantidad = tratamientoService.contarTratamientosUltimos30Dias();
        return ResponseEntity.ok(cantidad);
    }

    @GetMapping("/ultimos-30-dias")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosUltimos30Dias() {
        List<Tratamiento> tratamientos = tratamientoService.obtenerTratamientosUltimos30Dias();
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/medicamentos-mas-usados")
    public ResponseEntity<Map<String, Integer>> obtenerMedicamentosMasUsados() {
        Map<String, Integer> medicamentos = tratamientoService.obtenerMedicamentosMasUsadosUltimos30Dias();
        return ResponseEntity.ok(medicamentos);
    }

    @GetMapping("/top3-medicamentos-vendidos")
    public ResponseEntity<List<Map<String, Object>>> obtenerTop3MedicamentosMasVendidos() {
        List<Map<String, Object>> medicamentos = tratamientoService.obtenerTop3MedicamentosMasVendidos();
        return ResponseEntity.ok(medicamentos);
    }


    @GetMapping("/veterinario/{idVeterinario}")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosPorVeterinario(@PathVariable Integer idVeterinario) {
        List<Tratamiento> tratamientos = tratamientoService.obtenerTratamientosPorVeterinario(idVeterinario);
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/mascota/{idMascota}")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientoPorMascota(@PathVariable Integer idMascota) {
        Mascota mascota = mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        List<Tratamiento> tratamientos = tratamientoRepository.findByMascota(mascota);
        return ResponseEntity.ok(tratamientos);
    }
}