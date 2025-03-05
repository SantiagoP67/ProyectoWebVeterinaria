package com.veterinaria.demo.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.servicio.MascotaService;

@Controller
@RequestMapping("mascota")
public class MascotaController {
    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
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
        model.addAttribute("mascota", mascota);
        return "detalle_mascota";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "crear_mascota";
    }

    @PostMapping("/crear")
    public String crearMascota(@ModelAttribute Mascota mascota, @RequestParam("cedula") String cedula) {
        mascotaService.crearMascota(mascota, cedula);
        return "redirect:/mascota";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        model.addAttribute("mascota", mascota);
        return "editar_mascota";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarMascota(@PathVariable Integer id, @ModelAttribute Mascota mascota) {
        mascotaService.actualizarMascota(id, mascota);
        return "redirect:/mascota";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Integer id) {
        mascotaService.eliminarMascota(id);
        return "redirect:/mascota";
    }
}