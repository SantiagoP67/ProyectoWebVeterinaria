package com.veterinaria.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {
    @GetMapping("/inicio_sesion")
    public String mostrarPaginaLogin() {
        return "inicio_sesion"; 
    }
}
