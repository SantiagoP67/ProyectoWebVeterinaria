package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.repositorio.ClienteRepository;
import com.veterinaria.demo.repositorio.MascotaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import com.veterinaria.demo.servicio.ClienteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController{

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private MascotaRepository mascotaRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.obtenerTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente detalleCliente(@PathVariable Integer id, Model model){
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente,
                                               @RequestParam("confirm_password") String confirmPassword) {
        if (!cliente.getContrasena().equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("Las contraseñas no coinciden");
        }

        clienteService.crearCliente(cliente);
        return ResponseEntity.ok("Usuario creado correctamente");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente clienteactualizado){
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        clienteExistente.setNombre(clienteactualizado.getNombre());
        clienteExistente.setCorreo(clienteactualizado.getCorreo());
        clienteExistente.setCelular(clienteactualizado.getCelular());
        clienteExistente.setFoto(clienteactualizado.getFoto());
        clienteExistente.setCedula(clienteactualizado.getCedula());
        clienteExistente.setNombreUsuario(clienteactualizado.getNombreUsuario());
        clienteExistente.setContrasena(clienteactualizado.getContrasena());

        Cliente clienteGuardado = clienteRepository.save(clienteExistente);
        return ResponseEntity.ok(clienteGuardado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, String>> eliminarCliente(@PathVariable Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        clienteRepository.delete(cliente);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Cliente eliminado correctamente");

        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}