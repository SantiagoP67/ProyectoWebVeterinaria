package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Administrador;
import com.veterinaria.demo.repositorio.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.veterinaria.demo.servicio.AdministradorService;

import java.util.List;

@RestController
@RequestMapping("/administrador")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController{

    @Autowired 
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> listar() {
        return administradorService.obtenerTodosAdministradors();
    }

    @GetMapping("/{id}")
    public Administrador detalleAdministrador(@PathVariable Integer id) {
        return administradorService.obtenerAdministradorPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Administrador administrador,
                                               @RequestParam("confirm_password") String confirmPassword) {
        if(!administrador.getContrasena().equals(confirmPassword)){
            return ResponseEntity.badRequest().body("Las contraseñas no coinciden");
        }

        administradorService.crearAdministrador(administrador);
        return ResponseEntity.ok("Administrador creada");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Administrador> editar(@PathVariable Integer id, @RequestBody Administrador adminActualizado) {
        Administrador adminEditado = administradorService.editarAdministrador(id, adminActualizado);
        return ResponseEntity.ok(adminEditado);
    }
}