package com.veterinaria.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/inicio_sesion")
    public String mostrarPaginaLogin() {
        return "inicio_sesion"; 
    }

    @GetMapping("/index")
    public String mostrarPaginaIndex() {
        return "index";
    }
    @GetMapping("/")
    public String redirigirAIndex() {
        return "index"; 
    }
    @GetMapping("/registro_usuario")
    public String mostrarPaginaRegistro() {
        return "registro_usuario"; // Debe existir en src/main/resources/templates/
    }
}
