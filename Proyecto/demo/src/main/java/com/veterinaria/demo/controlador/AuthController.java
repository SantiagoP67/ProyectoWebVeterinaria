package com.veterinaria.demo.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /*@PostMapping("/inicio_sesion")
    public String iniciarSesion(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model, HttpSession session) {

        Cliente cliente = clienteService.validarCliente(username, password);
        if (cliente != null) {
            session.setAttribute("idCliente", cliente.getIdCliente());
            session.setAttribute("cedula", cliente.getCedula());
            session.setAttribute("nombreCliente", cliente.getNombre());
            session.setAttribute("fotoCliente", cliente.getFoto());
            session.setAttribute("rol", "CLIENTE");  // Asignar rol

            return "index";
        }

        Veterinario veterinario = veterinarioService.validarVeterinario(username, password);
        if (veterinario != null) {
            session.setAttribute("cedula", veterinario.getCedula());
            session.setAttribute("idVeterinario", veterinario.getIdVeterinario());
            session.setAttribute("nombre", veterinario.getNombre());
            session.setAttribute("foto", veterinario.getFoto());
            session.setAttribute("rol", "VETERINARIO");  // Asignar rol


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

            session.setAttribute("mascotasAtendidas", mascotasAtendidas);

        // Obtener lista de clientes sin duplicados
            List<Cliente> clientes = mascotasAtendidas.stream()
            .map(Mascota::getCliente)
            .distinct()  // Evita duplicados en la lista
            .collect(Collectors.toList());

            // Depuración: mostrar clientes en consola
            System.out.println("🔍 Clientes encontrados:");
            clientes.forEach(c -> System.out.println("ID: " + c.getIdCliente() + ", Nombre: " + c.getNombre()));

            // Verificar si hay clientes
            if (clientes.isEmpty()) {
            System.out.println("⚠ No se encontraron clientes para las mascotas atendidas.");
            }

            // Guardar lista de clientes en sesión
            session.setAttribute("clientesAtendidos", clientes);

            // Retornar la vista de veterinario
            return "veterinario";
        }

        Administrador administrador = administradorService.validarAdministrador(username, password);
        if (administrador != null) {
            session.setAttribute("cedula", administrador.getCedula());
            session.setAttribute("rol", "ADMINISTRADOR");  // Asignar rol

            return "administrador";
        }

        // Si no coincide con ninguno, muestra error
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "inicio_sesion";
    }*/

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
        request.getSession().invalidate(); 
        return "redirect:/"; 
    }

}