package com.veterinaria.demo.controlador;

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
public class MedicamentoController{

    @Autowired 
    MedicamentoService medicamentoService;

    @Autowired
    TratamientoService tratamientoService;

    @GetMapping
    public List<Medicamento> mostrarMedicamentos(){
        return medicamentoService.obtenerTodosTratamientos();
    }

    @GetMapping("/{id}")
    public Medicamento detalleMedicamento(@PathVariable Integer id){
        return medicamentoService.obtenerMedicamentoPorId(id);
    }

    @GetMapping("/por-tratamiento/{idTratamiento}")
    public ResponseEntity<List<Medicamento>> obtenerMedicamentosPorTratamiento(@PathVariable Integer idTratamiento) {
        Tratamiento tratamiento = tratamientoService.obtenerTratamientoPorId(idTratamiento);

        if (tratamiento == null) {
            return ResponseEntity.notFound().build();
        }

    
        List<Medicamento> medicamentos = tratamiento.getTratamientoMedicamentos().stream()
                .map(tm -> new Medicamento(
                        tm.getMedicamento().getIdMedicamento(),
                        tm.getMedicamento().getNombre(),
                        tm.getMedicamento().getPrecioCompra(),
                        tm.getMedicamento().getPrecioVenta(),
                        tm.getMedicamento().getUnidadesDisponibles(),
                        tm.getMedicamento().getUnidadesVendidas(),
                        tm.getMedicamento().getTratamientoMedicamentos(),
                        tm.getMedicamento().getFacturaMedicamentos()
                ))
                .collect(Collectors.toList());
    
        return ResponseEntity.ok(medicamentos);
    }
}