package com.veterinaria.demo.entidad;

import com.veterinaria.demo.repositorio.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class DataBaseInit implements ApplicationRunner {

    private final ClienteRepository clienteRepository;
    private final VeterinarioRepository veterinarioRepository;
    private final AdministradorRepository administradorRepository;
    private final ServicioRepository servicioRepository;
    private final MetodoPagoRepository metodoPagoRepository;
    private final FacturaRepository facturaRepository;
    private final MascotaRepository mascotaRepository;
    private final TratamientoRepository tratamientoRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final TratamientoMedicamentoRepository tratamientoMedicamentoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Creación de clientes
        Cliente cliente = new Cliente(null, "Juan Pérez", "juan@gmail.com", "123456789", "100200300", "juan_p","123", null, null);
        clienteRepository.save(cliente);

        // Creación de veterinarios
        Veterinario veterinario = new Veterinario(null, "Dr. Smith", "123456", "Veterinario General", "foto.png", 1, 10, "drsmith","123", null, null);
        veterinarioRepository.save(veterinario);

        // Creación de administradores
        Administrador administrador = new Administrador(null, "Carlos López", "987654321", "carlos_admin","123");
        administradorRepository.save(administrador);

        // Creación de servicios
        Servicio servicioConsulta = new Servicio(null, "Consulta General", "Revisión general de la mascota", 50000f, null, null, null);
        servicioRepository.save(servicioConsulta);

        // Creación de métodos de pago
        MetodoPago metodoPago = new MetodoPago(null, "Tarjeta de Crédito", null);
        metodoPagoRepository.save(metodoPago);

        // Creación de una factura
        Factura factura = new Factura(null, new Timestamp(new Date().getTime()), 50000f, List.of(metodoPago), List.of(servicioConsulta));
        facturaRepository.save(factura);

        // Creación de una mascota
        Mascota mascota = new Mascota(null, "Firulais", "Labrador", 3, 20.5f, "Ninguna", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Labrador_on_Quantock_%282175262184%29.jpg/640px-Labrador_on_Quantock_%282175262184%29.jpg", new Date(), new Date(), null, 1, cliente);
        mascotaRepository.save(mascota);

        // Creación de un tratamiento
        Tratamiento tratamiento = new Tratamiento(null, "TRAT123", new Date(), "Tratamiento básico", veterinario, mascota, servicioConsulta, null);
        tratamientoRepository.save(tratamiento);

        // Creación de un medicamento
        Medicamento medicamento = new Medicamento(null, "Antibiótico", 100.0f, 150.0f, 50, 10, null);
        medicamentoRepository.save(medicamento);

        // Asociación entre tratamiento y medicamento
        TratamientoMedicamento tratamientoMedicamento = new TratamientoMedicamento(null, tratamiento, medicamento, 2);
        tratamientoMedicamentoRepository.save(tratamientoMedicamento);

        System.out.println("Base de datos inicializada con datos de ejemplo.");
    }
}
