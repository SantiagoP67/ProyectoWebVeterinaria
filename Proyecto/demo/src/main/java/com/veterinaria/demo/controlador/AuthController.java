package com.veterinaria.demo.controlador;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.demo.entidad.Administrador;
import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.entidad.Veterinario;
import com.veterinaria.demo.servicio.AdministradorService;
import com.veterinaria.demo.servicio.ClienteService;
import com.veterinaria.demo.servicio.VeterinarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

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
            session.setAttribute("idCliente", cliente.getIdCliente());
            session.setAttribute("cedula", cliente.getCedula());
            session.setAttribute("nombreCliente", cliente.getNombre());
            session.setAttribute("fotoCliente", cliente.getFoto());
            return "index";
        }

        Veterinario veterinario = veterinarioService.validarVeterinario(username, password);
        if (veterinario != null) {
            session.setAttribute("cedula", veterinario.getCedula());
            session.setAttribute("idVeterinario", veterinario.getIdVeterinario());
            session.setAttribute("nombre", veterinario.getNombre());
            session.setAttribute("foto", veterinario.getFoto()); // Asegúrate de tener un método getUrlFoto()

// Obtener lista de mascotas atendidas por el veterinario
List<Mascota> mascotasAtendidas = veterinarioService.obtenerMascotasAtendidas(veterinario.getIdVeterinario());

            // Verificar si la lista tiene datos
            if (mascotasAtendidas.isEmpty()) {
                System.out.println("No hay mascotas atendidas para el veterinario con ID: " + veterinario.getIdVeterinario());
            } else {
                System.out.println("Mascotas atendidas encontradas:");
                for (Mascota m : mascotasAtendidas) {
                    System.out.println("ID: " + m.getIdMascota() + ", Nombre: " + m.getNombre() + ", Raza: " + m.getRaza());
                }
            }

            // Guardar en sesión
            session.setAttribute("mascotasAtendidas", mascotasAtendidas);


            // Obtener lista de clientes dueños de esas mascotas (evitando duplicados)
            Set<Cliente> clientes = mascotasAtendidas.stream()
                .map(Mascota::getCliente)
                .collect(Collectors.toSet());
            session.setAttribute("clientesAtendidos", clientes);

            return "veterinario";  
        }

        Administrador administrador = administradorService.validarAdministrador(username, password);
        if (administrador != null) {
            session.setAttribute("cedula", administrador.getCedula());
            return "administrador";
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

    @GetMapping("/cerrar-sesion")
    public String cerrarSesion(HttpServletRequest request) {
        request.getSession().invalidate(); // Cierra la sesión del usuario
        return "redirect:/"; // Redirige al index
    }

}