package com.veterinaria.demo.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.demo.ErrorHeading.NotFoundException;
import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.servicio.ClienteService;
import com.veterinaria.demo.servicio.MascotaService;
import com.veterinaria.demo.servicio.VeterinarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("mascota")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;


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
            model.addAttribute("dueno", mascota.getCliente());
            return "detalle_mascota";
        }else {
            throw new NotFoundException(id, "La mascota con ID " + id + " no existe.");
        }

    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("clientes", clienteService.obtenerTodosClientes());
        return "crear_mascota";
    }

    @PostMapping("/crear")
    public String crearMascota(@RequestParam("cedula") String cedula,
                               @ModelAttribute Mascota mascota,
                               HttpSession session, Model model) {

        if (cedula != null) {
            mascotaService.crearMascota(mascota, cedula);

            List<Mascota> mascotasAtendidas = (List<Mascota>) session.getAttribute("mascotasAtendidas");

            if (mascotasAtendidas == null) {
                // Si no existe la lista en la sesión, obtenerla del servicio
                mascotasAtendidas = veterinarioService.obtenerMascotasAtendidas((int) session.getAttribute("idVeterinario"));
            }

            // Agregar la nueva mascota a la lista
            mascotasAtendidas.add(mascota);

            // Guardar la lista actualizada en la sesión
            session.setAttribute("mascotasAtendidas", mascotasAtendidas);

            List<Cliente> clientes = mascotasAtendidas.stream()
                    .map(Mascota::getCliente)
                    .distinct()
                    .collect(Collectors.toList());

            // Depuración: mostrar clientes en consola
            System.out.println("🔍 Clientes encontrados:");
            clientes.forEach(c -> System.out.println("ID: " + c.getIdCliente() + ", Nombre: " + c.getNombre()));

            // Verificar si hay clientes
            if (clientes.isEmpty()) {
                System.out.println("⚠ No se encontraron clientes para las mascotas atendidas.");
            }
            session.setAttribute("clientesAtendidos", clientes);

            String rol = (String) session.getAttribute("rol");
            if ("VETERINARIO".equals(rol)) {
                return "redirect:/veterinario";
            }

            return "redirect:/inicio_sesion";
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

        return "ver_mascota_cliente";
    }
}