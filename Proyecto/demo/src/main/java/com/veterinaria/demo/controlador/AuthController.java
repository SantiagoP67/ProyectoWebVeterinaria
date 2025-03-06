package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/inicio_sesion")
    public String mostrarPaginaLogin() {
        return "inicio_sesion";
    }

    @PostMapping("/inicio_sesion")
    public String validarLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {

        Cliente cliente = clienteService.validarCliente(username, password);
        Integer idCliente = cliente.getIdCliente();                           
        if (cliente != null) {
            model.addAttribute("mensaje", "Inicio de sesión exitoso");
            return "redirect:/mascota/mascotas?idCliente=" + idCliente + ""; // Redirigir a la página principal
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "inicio_sesion";
        }
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
        return "registro_usuario";
    }
}
