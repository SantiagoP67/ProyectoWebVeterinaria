package com.veterinaria.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.demo.entidad.Administrador;
import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.entidad.Veterinario;
import com.veterinaria.demo.servicio.ClienteService;
import com.veterinaria.demo.servicio.AdministradorService;
import com.veterinaria.demo.servicio.VeterinarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterninarioService veterinarioService;

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("inicio_sesion")
    public String mostrarPaginaLogin() {
        return "inicio_sesion";
    }

    @PostMapping("/inicio_sesion")
    public String iniciarSesion(@RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {

        Cliente cliente = clienteService.validarCliente(username, password);
        if (cliente != null) {
            session.setAttribute("cedula", cliente.getCedula());
            return "redirect:/verMascotaCliente";
        }

        Veterinario veterinario = veterinarioService.validarVeterinario(username, password);
        if (veterinario != null) {
            session.setAttribute("cedula", veterinario.getCedula());
            return "redirect:/veterinario";
        }

        Administrador administrador = administradorService.validarAdministrador(username, password);
        if (administrador != null) {
            session.setAttribute("cedula", administrador.getCedula());
            return "redirect:/administrador";
        }

        // Si no coincide con ninguno, muestra error
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "inicio_sesion";
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