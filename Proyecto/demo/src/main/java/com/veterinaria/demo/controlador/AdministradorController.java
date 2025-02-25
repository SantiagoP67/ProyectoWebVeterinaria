package com.veterinaria.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


import com.veterinaria.demo.servicio.AdministradorService; 

@Controller
@RequestMapping("/administrador")
public class AdministradorController{

    @Autowired 
    AdministradorService administradorService;


    /*Pagina para buscar medicamentos
    @GetMapping ("/find")
    public String buscarInfoAdministrador(){
        return "mostrarInfoAdministrador";
    }*/
}