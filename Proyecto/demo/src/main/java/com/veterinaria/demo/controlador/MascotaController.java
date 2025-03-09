package com.veterinaria.demo.controlador;

import java.util.List;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.demo.ErrorHeading.NotFoundException;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.servicio.MascotaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("mascota")
public class MascotaController {
    private final MascotaService mascotaService;
    private final ClienteService clienteService;

    public MascotaController(MascotaService mascotaService, ClienteService clienteService) {
        this.mascotaService = mascotaService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String mostrarMascotas(Model model) {
        List<Mascota> mascotas = mascotaService.obtenerTodasMascotas();
        model.addAttribute("mascotas", mascotas);
        return "mascotas";
    }

    @GetMapping("/{id}")
    public String detalleMascota(@PathVariable Integer id, Model model) {
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        if(mascota!= null){
            model.addAttribute("mascota", mascota);
            return "detalle_mascota";
        }else {
            throw new NotFoundException(id, "La mascota con ID " + id + " no existe.");
        }

    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "crear_mascota";
    }

    @PostMapping("/crear")
    public String crearMascota(@ModelAttribute Mascota mascota, HttpSession session) {
        String cedula = (String) session.getAttribute("cedula"); // Obtener cédula de la sesión

        if (cedula != null) {
            mascotaService.crearMascota(mascota, cedula);
            return "verMascotaCliente";
        } else {
            return "redirect:/inicio_sesion?error=sesionExpirada";
        }
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        model.addAttribute("mascota", mascota);
        return "editar_mascota";
    }

    @PostMapping("/editar/{id}")
    public String actualizarMascota(@PathVariable Integer id, @ModelAttribute Mascota mascota) {
        mascotaService.actualizarMascota(id, mascota);
        return "redirect:/mascota";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Integer id, @ModelAttribute Mascota mascota) {
        mascotaService.cambiarEstado(id, mascota);
        return "redirect:/mascota";
    }

    @GetMapping("/mascotas")
    public String listarMascotas(@RequestParam("idCliente") Integer idCliente, Model model) {
        Cliente cliente = clienteService.obtenerClientePorId(idCliente); // Método para obtener el cliente
        List<Mascota> mascotas = mascotaService.obtenerMascotasPorCliente(idCliente);

        model.addAttribute("mascotas", mascotas);
        model.addAttribute("nombreCliente", cliente.getNombre());

        return "verMascotaCliente";
    }
}