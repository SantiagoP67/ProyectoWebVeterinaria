package com.veterinaria.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.veterinaria.demo.servicio.TratamientoService;


@Controller
@RequestMapping("/tratamiento")
public class TratamientoController{

    @Autowired
    TratamientoService tratamientoService; 

    /*Pagina para mostrar tratamientos
    @GetMapping ("/all")
    public String mostrarTratamientos(){
        return "mostrarTratamientos"; 
    }*/ 

    /*Pagina para buscar tratamientos
    @GetMapping ("/find")
    public String buscarInfoTratamiento(){
        return "mostrarInfoTratamiento"; 
    }*/
}