package com.veterinaria.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.veterinaria.demo.entidad.Tratamiento;
import com.veterinaria.demo.servicio.TratamientoService;

@SpringBootTest
public class TratamientoServiceTestNaive {
    @Autowired
    TratamientoService tratamientoService;

    @Test
    public void TratamientoService_createTratamiento_Tratamiento() {
        // Arrange
        Tratamiento tratamiento1 = new Tratamiento();
        Tratamiento tratamiento2 = new Tratamiento();

        // Act
        Tratamiento tratamiento = tratamientoService.createTratamiento(tratamiento);
        Tratamiento tratamiento2 = tratamientoService.createTratamiento(tratamiento2);

        // Assert
    }
}

/*
 * List<Tratamiento> obtenerTodosTratamientos();
    Tratamiento obtenerTratamientoPorId(Integer id);
    long contarTratamientosUltimos30Dias();
    List<Tratamiento> obtenerTratamientosUltimos30Dias();
    Map<String, Integer> obtenerMedicamentosMasUsadosUltimos30Dias();
    List<Map<String, Object>> obtenerTop3MedicamentosMasVendidos();
    List<Tratamiento> obtenerTratamientosPorVeterinario(Integer idVeterinario);
 */
