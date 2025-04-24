package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Medicamento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import com.veterinaria.demo.servicio.MedicamentoService;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController{

    @Autowired 
    MedicamentoService medicamentoService;

    @GetMapping
    public List<Medicamento> mostrarMedicamentos(){
        return medicamentoService.obtenerTodosTratamientos();
    }

    @GetMapping("/{id}")
    public Medicamento detalleMedicamento(@PathVariable Integer id){
        return medicamentoService.obtenerMedicamentoPorId(id);
    }
}