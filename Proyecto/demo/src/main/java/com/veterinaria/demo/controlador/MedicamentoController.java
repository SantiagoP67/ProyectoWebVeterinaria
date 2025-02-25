package com.veterinaria.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


import com.veterinaria.demo.servicio.MedicamentoService; 

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController{

    @Autowired 
    MedicamentoService medicamentoService;

    /*Pagina para mostrar Medicamentos 
    @GetMapping ("/all")
    public String mostrarMedicamentos(){
        return "mostrarMedicamentos"; 
    }*/ 

    /*Pagina para buscar medicamentos
    @GetMapping ("/find")
    public String buscarInfoMedicamento(){
        return "mostrarInfoMedicamento"; 
    }*/
}