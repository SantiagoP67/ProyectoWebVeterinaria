package com.veterinaria.demo.controlador;

import com.veterinaria.demo.dto.MedicamentoDTO;
import com.veterinaria.demo.dto.MedicamentoMapper;
import com.veterinaria.demo.entidad.Medicamento;
import com.veterinaria.demo.entidad.Tratamiento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.veterinaria.demo.servicio.MedicamentoService;
import com.veterinaria.demo.servicio.TratamientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamento")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController {

    @Autowired 
    MedicamentoService medicamentoService;

    @Autowired
    TratamientoService tratamientoService;

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> mostrarMedicamentos() {
        List<MedicamentoDTO> dtos = medicamentoService.obtenerTodosTratamientos().stream()
            .map(MedicamentoMapper.INSTANCE::convert)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> detalleMedicamento(@PathVariable Integer id) {
        Medicamento medicamento = medicamentoService.obtenerMedicamentoPorId(id);
        if (medicamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MedicamentoMapper.INSTANCE.convert(medicamento));
    }

    @GetMapping("/por-tratamiento/{idTratamiento}")
    public ResponseEntity<List<MedicamentoDTO>> obtenerMedicamentosPorTratamiento(@PathVariable Integer idTratamiento) {
        Tratamiento tratamiento = tratamientoService.obtenerTratamientoPorId(idTratamiento);

        if (tratamiento == null) {
            return ResponseEntity.notFound().build();
        }

        List<MedicamentoDTO> medicamentos = tratamiento.getTratamientoMedicamentos().stream()
                .map(tm -> MedicamentoMapper.INSTANCE.convert(tm.getMedicamento()))
                .collect(Collectors.toList());
    
        return ResponseEntity.ok(medicamentos);
    }
}