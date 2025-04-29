package com.veterinaria.demo.controlador;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.repositorio.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.veterinaria.demo.servicio.ClienteService;

import java.util.Collections;
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

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.obtenerTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente detalleCliente(@PathVariable Integer id, Model model){
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, String>> crearCliente(
            @RequestBody Cliente cliente,
            @RequestParam("confirm_password") String confirmPassword
    ) {
        // Verificar si la contraseña está vacía
        if (cliente.getContrasena() == null || cliente.getContrasena().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "La contraseña no puede estar vacía"));
        }

        // Verificar si las contraseñas coinciden
        if (!cliente.getContrasena().equals(confirmPassword)) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Las contraseñas no coinciden"));
        }

        // Crear el cliente
        try {
            clienteService.crearCliente(cliente);
            // Devolver respuesta en formato JSON
            Map<String, String> response = new HashMap<>();
            response.put("message", "Usuario creado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // En caso de error, devolver un mensaje de error
            Map<String, String> response = new HashMap<>();
            response.put("error", "Error al crear el cliente");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
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
        Map<String, String> respuesta = new HashMap<>();

        if (!clienteRepository.existsById(id)) {
            respuesta.put("mensaje", "Cliente no encontrado con ID: " + id);
            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }

        clienteRepository.deleteById(id);

        respuesta.put("mensaje", "Cliente eliminado correctamente");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }



    @GetMapping("/idClientePorNombreUsuario/{nombreUsuario}")
public ResponseEntity<Integer> obtenerIdClientePorNombreUsuario(@PathVariable String nombreUsuario) {
    Integer idCliente = clienteService.obtenerIdClientePorNombreUsuario(nombreUsuario);
    if (idCliente != null) {
        return ResponseEntity.ok(idCliente);
    } else {
        return ResponseEntity.notFound().build();
    }
}
    @GetMapping("/buscar")
    public ResponseEntity<List<Cliente>> buscarPorNombre(@RequestParam String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombreContainingIgnoreCase(nombre);
        return ResponseEntity.ok(clientes);
    }


}