package com.veterinaria.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.servicio.ClienteService;

@Controller
public class AuthController {

    @Autowired
    private ClienteService clienteService; 

    @GetMapping("inicio_sesion")
    public String mostrarPaginaLogin() {
        return "inicio_sesion"; 
    }

    @PostMapping("/inicio_sesion")
    public String iniciarSesion(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model) {
        Cliente cliente = clienteService.validarCliente(username, password);
    
        if (cliente == null) { 
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "inicio_sesion"; // Volver a la página de login con error
        }
    
        return "redirect:/index"; // Si las credenciales son correctas, redirige a la página principal
    }
    

    @GetMapping("index")
    public String mostrarPaginaIndex() {
        return "index";
    }

    @GetMapping
    public String redirigirAIndex() {
        return "index"; 
    }

    @GetMapping("registro_usuario")
    public String mostrarPaginaRegistro() {
        return "registro_usuario"; 
    }
}