package com.veterinaria.demo.controlador;

import java.util.List;
import java.util.stream.Collectors;

import com.veterinaria.demo.repositorio.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.entidad.Veterinario;
import com.veterinaria.demo.servicio.VeterinarioService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController{

    @Autowired
    private VeterinarioService veterinarioService;
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @GetMapping
    public List<Veterinario> listar(Model model){
        return veterinarioService.obtenerTodosVeterinarios();
    }

    @GetMapping("/{id}")
    public Veterinario detalleVeterinario(@PathVariable Integer id){
        return veterinarioService.obtenerVeterinarioPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearVeterinario(@RequestBody Veterinario veterinario,
                                           @RequestParam("confirm_password") String confirmPassword) {
        if (!veterinario.getContrasena().equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("Las contraseñas no coinciden");
        }

        veterinarioService.crearVeterinario(veterinario);
        return ResponseEntity.ok("Veterinario creado");
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<Veterinario> actualizarVeterinario(@PathVariable Integer id, @RequestBody Veterinario veterinarioactualizado) {
        Veterinario veterinarioExistente = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado con ID: " + id));

        veterinarioExistente.setNombre(veterinarioactualizado.getNombre());
        veterinarioExistente.setCedula(veterinarioactualizado.getCedula());
        veterinarioExistente.setEspecialidad(veterinarioactualizado.getEspecialidad());
        veterinarioExistente.setFoto(veterinarioactualizado.getFoto());
        veterinarioExistente.setEstado(veterinarioactualizado.getEstado());
        veterinarioExistente.setNumeroAtenciones(veterinarioactualizado.getNumeroAtenciones());
        veterinarioExistente.setNombreUsuario(veterinarioactualizado.getNombreUsuario());
        veterinarioExistente.setContrasena(veterinarioactualizado.getContrasena());

        Veterinario veterinarioGuardado = veterinarioRepository.save(veterinarioExistente);
        return ResponseEntity.ok(veterinarioGuardado);

    }
    

    @GetMapping("mascotas_atendidas")
    public String verMascotasAtendidas(HttpSession session) {
        Integer idVeterinario = (Integer) session.getAttribute("idVeterinario");

        if (idVeterinario == null) {
            return "redirect:/inicio_sesion";
        }

        List<Mascota> mascotasAtendidas = veterinarioService.obtenerMascotasAtendidas(idVeterinario);
        session.setAttribute("mascotasAtendidas", mascotasAtendidas);

        List<Cliente> clientes = mascotasAtendidas.stream()
            .map(Mascota::getCliente)
            .distinct()
            .collect(Collectors.toList());
        session.setAttribute("clientesAtendidos", clientes);

        return "veterinario";
    }

}