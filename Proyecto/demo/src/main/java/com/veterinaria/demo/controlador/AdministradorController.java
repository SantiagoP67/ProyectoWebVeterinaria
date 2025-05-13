package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Administrador;
import com.veterinaria.demo.entidad.UserEntity;
import com.veterinaria.demo.repositorio.UserRepository;
import com.veterinaria.demo.seguridad.CustomUserDetailsService;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

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

        if(userRepository.existsByUsername(administrador.getNombreUsuario())) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya está registrado");
        }

        if(!administrador.getContrasena().equals(confirmPassword)){
            return ResponseEntity.badRequest().body("Las contraseñas no coinciden");
        }

        UserEntity userEntity = customUserDetailsService.andminToUser(administrador);
        administrador.setUser(userEntity);
        administradorService.crearAdministrador(administrador);
        return ResponseEntity.ok("Administrador creada");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Administrador> editar(@PathVariable Integer id, @RequestBody Administrador adminActualizado) {
        Administrador adminEditado = administradorService.editarAdministrador(id, adminActualizado);
        return ResponseEntity.ok(adminEditado);
    }
}