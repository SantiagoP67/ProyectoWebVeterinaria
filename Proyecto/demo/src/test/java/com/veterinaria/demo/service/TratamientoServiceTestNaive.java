package com.veterinaria.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.veterinaria.demo.entidad.Cliente;
import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.entidad.Servicio;
import com.veterinaria.demo.entidad.Tratamiento;
import com.veterinaria.demo.entidad.Veterinario;
import com.veterinaria.demo.repositorio.ClienteRepository;
import com.veterinaria.demo.repositorio.MascotaRepository;
import com.veterinaria.demo.repositorio.ServicioRepository;
import com.veterinaria.demo.repositorio.TratamientoRepository;
import com.veterinaria.demo.repositorio.VeterinarioRepository;
import com.veterinaria.demo.servicio.TratamientoService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServiceTestNaive {

    @Autowired
    private TratamientoService tratamientoService;
    
    @Autowired
    private TratamientoRepository tratamientoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private VeterinarioRepository veterinarioRepository;
    
    @Autowired
    private ServicioRepository servicioRepository;
    
    @BeforeEach
    public void setUp() {
        clienteRepository.save(new Cliente(
            null, "Juan Pérez", "juan@example.com", "3216549870",
            "foto.jpg", "123456789", "juanp", "1234",
            null, null));
        
        mascotaRepository.save(new Mascota(
            null, "Firulais", "Labrador", 5, 20.0f,
            "Ninguna", "mascota.jpg", new Date(), new Date(),
            null, 1, clienteRepository.findAll().get(0)));
        
        veterinarioRepository.save(new Veterinario(
            null, "Dra. Laura", "987654321", "General",
            "fotoVet.jpg", "Sede A", 1, 0,
            "laura.vet", "pass", null, null));
        
        servicioRepository.save(new Servicio(
            null, "Consulta General", "Chequeo médico completo", 60.0f,
            "front.jpg", "back.jpg", null, null, null));
        
        // Tratamiento reciente (hoy)
        tratamientoRepository.save(new Tratamiento(
            null, "TRAT-001", new Date(),
            "Consulta reciente", 
            veterinarioRepository.findAll().get(0), 
            mascotaRepository.findAll().get(0), 
            servicioRepository.findAll().get(0), 
            null));
        
        // Tratamiento antiguo (hace 60 días)
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -60);
        tratamientoRepository.save(new Tratamiento(
            null, "TRAT-002", calendar.getTime(),
            "Consulta antigua", 
            veterinarioRepository.findAll().get(0), 
            mascotaRepository.findAll().get(0), 
            servicioRepository.findAll().get(0), 
            null));
    }

    @Test
    public void TratamientoService_crearTratamiento_Tratamiento() {
        // Arrange
        Tratamiento tratamiento1 = new Tratamiento();
        Tratamiento tratamiento2 = new Tratamiento();

        // Act
        Tratamiento newTratamiento = tratamientoService.crearTratamiento(tratamiento1);
        newTratamiento = tratamientoService.crearTratamiento(tratamiento2);

        // Assert
        assertThat(newTratamiento).isNotNull();
    }

    @Test
    public void TratamientoService_obtenerTodosTratamientos_NotEmptyListTratamientos() {
        // Act
        List<Tratamiento> tratamientos = tratamientoService.obtenerTodosTratamientos();
        
        // Assert
        assertThat(tratamientos).isNotEmpty();
        assertThat(tratamientos.size()).isEqualTo(2);
        assertThat(tratamientos)
            .extracting(Tratamiento::getCodigo)
            .containsExactlyInAnyOrder("TRAT-001", "TRAT-002");
    }

    @Test
    public void TratamientoService_obtenerTratamientoPorId_Tratamiento() {
        // Arrange
        Integer id = tratamientoRepository.findByCodigo("TRAT-001").getIdTratamiento();
        
        // Act
        Tratamiento encontrado = tratamientoService.obtenerTratamientoPorId(id);
        
        // Assert
        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getCodigo()).isEqualTo("TRAT-001");
    }

    @Test
    public void TratamientoService_contarTratamientosUltimos30Dias_Count() {
        // Act
        long count = tratamientoService.contarTratamientosUltimos30Dias();
        
        // Assert
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void TratamientoService_obtenerTratamientosUltimos30Dias_NotEmptyListTratamientos() {
        // Act
        List<Tratamiento> tratamientos = tratamientoService.obtenerTratamientosUltimos30Dias();
        
        // Assert
        assertThat(tratamientos).hasSize(1);
        assertThat(tratamientos.get(0).getCodigo()).isEqualTo("TRAT-001");
    }

    @Test
    public void TratamientoService_obtenerMedicamentosMasUsadosUltimos30Dias_NotEmptyListMedicamentos() {
        // Act
        Map<String, Integer> resultados = tratamientoService.obtenerMedicamentosMasUsadosUltimos30Dias();
        
        // Assert
        assertThat(resultados).isNotNull();
    }

    @Test
    public void TratamientoService_obtenerTop3MedicamentosMasVendidos_NotEmptyListMedicamentos() {
        // Act
        List<Map<String, Object>> resultados = tratamientoService.obtenerTop3MedicamentosMasVendidos();
        
        // Assert
        assertThat(resultados).isNotNull();
        assertThat(resultados.size()).isLessThanOrEqualTo(3);
    }

    @Test
    public void TratamientoService_obtenerTratamientosPorVeterinario_NotEmptyListTratamientos() {
        // Act
        List<Tratamiento> tratamientos = tratamientoService.obtenerTratamientosPorVeterinario(
            veterinarioRepository.findAll().get(0).getIdVeterinario());
        
        // Assert
        assertThat(tratamientos).hasSize(2);
        assertThat(tratamientos)
            .extracting(t -> t.getVeterinario().getNombre())
            .containsOnly("Dra. Laura");
    }
}