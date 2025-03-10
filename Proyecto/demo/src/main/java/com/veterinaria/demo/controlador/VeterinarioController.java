package com.veterinaria.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.demo.entidad.Veterinario;
import com.veterinaria.demo.servicio.VeterinarioService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController{

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public String listar(Model model){
        List<Veterinario> veterinario= veterinarioService.obtenerTodosVeterinarios();
        model.addAttribute("veterinarios", veterinario);
        return "veterinario";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion( Model model){
        model.addAttribute("veterinario", new Veterinario());
        return "registro_veterinario";
    }

    @PostMapping("/crear")
    public String crearCliente(@ModelAttribute Veterinario veterinario,
                               @RequestParam("confirm_password") String confirmPassword,
                               Model model) {
        if (!veterinario.getContrasena().equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "registro_veterinario";
        }

        veterinarioService.crearVeterinario(veterinario);
        return "redirect:/cliente";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model){
        Veterinario veterinario = veterinarioService.obtenerVeterinarioPorId(id);
        model.addAttribute("veterinario", veterinario);
        return("registro_veterinario");
    }

    @PostMapping("/editar/{id}")
    public String actualizarVeterinario(@PathVariable Integer id, @ModelAttribute Veterinario veterinario) {
        veterinarioService.editarVeterinario(id, veterinario);
        return "redirect:/veterinario"; // Redirigir a la lista de veterinarios
    }
    
    /*  @PostMapping("/actualizar/{id}")
    public String actualizarCliente(@PathVariable Integer id, Cliente cliente){
        clienteService.editarCliente(id, cliente);
        return "redirect:/cliente";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id){
        clienteService.eliminarCliente(id);
        return "redirect:/cliente";
    }*/ 
}