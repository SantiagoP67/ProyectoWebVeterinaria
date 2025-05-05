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

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController{

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

        Tratamiento tratamientoExistente = tratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado"));

        // Actualizar campos básicos
        tratamientoExistente.setCodigo(tratamientoActualizado.getCodigo());
        tratamientoExistente.setFecha(tratamientoActualizado.getFecha());
        tratamientoExistente.setDetalles(tratamientoActualizado.getDetalles());

        // Actualizar relaciones
        Mascota mascota = mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        tratamientoExistente.setMascota(mascota);

        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        tratamientoExistente.setServicio(servicio);

        if (idVeterinario != null) {
            Veterinario veterinario = veterinarioRepository.findById(idVeterinario)
                    .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
            tratamientoExistente.setVeterinario(veterinario);
        } else {
            tratamientoExistente.setVeterinario(null);
        }

        // Limpiar medicamentos anteriores
        tratamientoExistente.getTratamientoMedicamentos().clear();

        List<TratamientoMedicamento> nuevosTM = new ArrayList<>();
        List<Medicamento> medicamentos = medicamentoRepository.findAllById(idsMedicamentos);

        for (Medicamento medicamento : medicamentos) {
            TratamientoMedicamento tm = new TratamientoMedicamento();
            tm.setTratamiento(tratamientoExistente);
            tm.setMedicamento(medicamento);
            tm.setCantidad(medicamentos.size());
            nuevosTM.add(tm);
        }

        tratamientoExistente.getTratamientoMedicamentos().addAll(nuevosTM);

        Tratamiento guardado = tratamientoRepository.save(tratamientoExistente);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTratamiento(@PathVariable Integer id) {
        Tratamiento tratamiento = tratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado"));

        tratamientoRepository.delete(tratamiento);

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