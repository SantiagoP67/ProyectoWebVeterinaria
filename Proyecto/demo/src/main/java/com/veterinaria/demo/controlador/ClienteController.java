package com.veterinaria.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


import com.veterinaria.demo.servicio.ClienteService; 

@Controller
@RequestMapping("/cliente")
public class ClienteController{

    @Autowired 
    ClienteService clienteService;

    /*Pagina para mostrar Medicamentos 
    @GetMapping ("/all")
    public String mostrarClientes(){
        return "mostrarClientes"; 
    }*/ 

    /*Pagina para buscar medicamentos
    @GetMapping ("/find")
    public String buscarInfoClientes(){
        return "mostrarInfoClientes"; 
    }*/
}