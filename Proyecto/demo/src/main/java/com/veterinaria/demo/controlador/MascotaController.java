package com.veterinaria.demo.controlador;

import java.util.List;

import com.veterinaria.demo.entidad.Tratamiento;
import com.veterinaria.demo.repositorio.TratamientoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.repositorio.ClienteRepository;
import com.veterinaria.demo.repositorio.MascotaRepository;
import com.veterinaria.demo.servicio.MascotaService;

@RestController
@RequestMapping("mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    /**
     * Muestra todas las mascotas registradas.
     * URL: http://localhost:8082/mascota
     */
    @GetMapping
    public List<Mascota> mostrarMascotas(Model model) {
        return mascotaService.obtenerTodasMascotas();
    }

    /**
     * Muestra los detalles de una mascota por su ID.
     * URL: http://localhost:8082/mascota/{id}
     */
    @GetMapping("/{id}")
    public Mascota detalleMascota(@PathVariable Integer id, Model model) {
        return mascotaService.obtenerMascotaPorId(id);
    }

    /**
     * Lista las mascotas asociadas a un cliente específico.
     * URL: http://localhost:8082/mascota/mascotas?idCliente=1
     */
    @GetMapping("/mascotas")
    public List<Mascota> listarMascotas(@RequestParam("idCliente") Integer idCliente) {
        return mascotaService.obtenerMascotasPorCliente(idCliente);
    }

    /**
     * Crea una nueva mascota y la asocia a un cliente existente.
     * URL: http://localhost:8082/mascota/agregar?idCliente=123
     * Body: JSON con datos de la mascota.
     */
    @PostMapping("/agregar")
    public ResponseEntity<Mascota> agregarMascota(@RequestBody Mascota mascota, @RequestParam Integer idCliente) {
        // Busca el cliente por ID
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Asocia la mascota con el cliente
        mascota.setCliente(cliente);

        // Guarda la mascota en la base de datos
        Mascota guardada = mascotaRepository.save(mascota);

        // Devuelve la mascota guardada como respuesta
        return ResponseEntity.ok(guardada);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Mascota> editarMascota(@PathVariable Integer id, @RequestBody Mascota mascotaActualizada) {
        // Verifica si la mascota existe
        Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));

        // Actualiza los campos necesarios
        mascotaExistente.setNombre(mascotaActualizada.getNombre());
        mascotaExistente.setRaza(mascotaActualizada.getRaza());
        mascotaExistente.setEdad(mascotaActualizada.getEdad());
        mascotaExistente.setPeso(mascotaActualizada.getPeso());
        mascotaExistente.setEstado(mascotaActualizada.getEstado());
        mascotaExistente.setEnfermedad(mascotaActualizada.getEnfermedad());
        mascotaExistente.setFoto(mascotaActualizada.getFoto());
        mascotaExistente.setFechaNacimiento(mascotaActualizada.getFechaNacimiento());
        mascotaExistente.setFechaIngreso(mascotaActualizada.getFechaIngreso());
        mascotaExistente.setFechaSalida(mascotaActualizada.getFechaSalida());

        // Si también se quiere actualizar el cliente asociado
        if (mascotaActualizada.getCliente() != null) {
            Integer idCliente = mascotaActualizada.getCliente().getIdCliente();
            Cliente cliente = clienteRepository.findById(idCliente)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));
            mascotaExistente.setCliente(cliente);
        }

        // Guarda la mascota actualizada
        Mascota mascotaGuardada = mascotaRepository.save(mascotaExistente);
        return ResponseEntity.ok(mascotaGuardada);
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<Mascota> eliminarMascota(@PathVariable Integer id) {
        // Verifica si la mascota existe
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));

        // Cambia el estado a 'inactiva' o el que uses para marcar eliminación lógica
        mascotaService.cambiarEstado(id, mascota);

        // Guarda la mascota con el nuevo estado
        mascotaRepository.save(mascota);

        return ResponseEntity.ok(mascota);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Mascota>> buscarPorNombre(@RequestParam String nombre) {
        List<Mascota> mascotas = mascotaRepository.findByNombreContainingIgnoreCase(nombre);
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/mascotas-en-tratamiento/{idCliente}")
    public ResponseEntity<List<Mascota>> obtenerMascotasEnTratamientoPorCliente(@PathVariable Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        List<Mascota> mascotas = mascotaRepository.findByCliente(cliente);

        // Filtrar mascotas que tengan al menos un tratamiento
        List<Mascota> mascotasConTratamiento = mascotas.stream()
                .filter(mascota -> !tratamientoRepository.findByMascota(mascota).isEmpty())
                .toList();

        return ResponseEntity.ok(mascotasConTratamiento);
    }

    @GetMapping("/cantidadMascotas")
    public ResponseEntity<Long> cantidadMascotas() {
        Long cantidad = mascotaRepository.count();  // Esto obtiene la cantidad de mascotas
        return ResponseEntity.ok(cantidad);  // Devuelve la cantidad como respuesta
    }
    
    @GetMapping("/cantidadMascotasPorCliente/{idCliente}")
    public ResponseEntity<Integer> cantidadMascotasPorCliente(@PathVariable Integer idCliente) {
        Integer cantidad = mascotaService.countByClienteIdCliente(idCliente);
        return ResponseEntity.ok(cantidad);
    }

    /**
     * Obtiene la cantidad de mascotas activas (estado = 1)
     * URL: GET http://localhost:8082/mascota/cantidadMascotasActivas
     */
    @GetMapping("/cantidadMascotasActivas")
    public ResponseEntity<Long> contarMascotasActivas() {
        Long cantidad = mascotaService.contarMascotasActivas();
        return ResponseEntity.ok(cantidad);
    }

    /**
     * Obtiene la lista de mascotas activas (estado = 1)
     * URL: GET http://localhost:8082/mascota/activas
     */
    @GetMapping("/activas")
    public ResponseEntity<List<Mascota>> obtenerMascotasActivas() {
        List<Mascota> mascotasActivas = mascotaService.obtenerMascotasActivas();
        return ResponseEntity.ok(mascotasActivas);
    }

    @GetMapping("/por-tratamiento/{id}")
    public ResponseEntity<Mascota> obtenerMascotaPorTratamiento(@PathVariable Integer id) {
        Tratamiento tratamiento = tratamientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tratamiento no encontrado"));
        Mascota mascota = tratamiento.getMascota();
        if (mascota == null) {
            throw new EntityNotFoundException("No hay mascota asociada a este tratamiento");
        }
        return ResponseEntity.ok(mascota);
    }
}