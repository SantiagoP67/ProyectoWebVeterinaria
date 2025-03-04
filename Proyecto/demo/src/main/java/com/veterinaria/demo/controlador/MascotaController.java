package com.veterinaria.demo.controlador;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.servicio.MascotaService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mascota")
public class MascotaController {
    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping("/mascotas")
    public String mostrarMascotas(Model model) {
        List<Mascota> mascotas = mascotaService.obtenerTodasMascotas();
        model.addAttribute("mascotas", mascotas);
        return "mascotas";
    }

    @GetMapping("/mascotas/{id}")
    public String detalleMascota(@PathVariable Integer id, Model model) {
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        model.addAttribute("mascota", mascota);
        return "detalle_mascota";
    }

    @GetMapping
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("mascota", new Mascota()); // Para enlazar el formulario con un objeto vacío
        return "crear_mascota";
    }

    @PostMapping
    public String crearmascota(@ModelAttribute Mascota mascota, @RequestParam("cedula") String cedula) {
        mascotaService.crearMascota(mascota, cedula);
        return "redirect:/mascota/mascotas";
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
        return "redirect:/mascota/mascotas";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Integer id) {
        mascotaService.eliminarMascota(id);
        return "redirect:/mascota/mascotas";
    }


}
