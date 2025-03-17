package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import com.veterinaria.demo.servicio.ClienteService;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController{

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model){
        List<Cliente> clientes = clienteService.obtenerTodosClientes();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion( Model model){
        model.addAttribute("cliente", new Cliente());
        return "registro_usuario";
    }

    @PostMapping("/crear")
    public String crearCliente(@ModelAttribute Cliente cliente,
                               @RequestParam("confirm_password") String confirmPassword,
                               Model model) {
        if (!cliente.getContrasena().equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "registro_usuario";
        }

        clienteService.crearCliente(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model){
        Cliente cliente = clienteService.obtenerClientePorId(id);
        model.addAttribute("cliente", cliente);
        return("editar_info_usuario");
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCliente(@PathVariable Integer id, Cliente cliente){
        clienteService.editarCliente(id, cliente);
        return "redirect:/index";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id){
        clienteService.eliminarCliente(id);
        return "redirect:/cliente";
    }
}