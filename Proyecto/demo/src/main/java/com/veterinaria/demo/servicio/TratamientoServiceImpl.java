package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Tratamiento;
import com.veterinaria.demo.repositorio.TratamientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TratamientoServiceImpl implements TratamientoService{
    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> obtenerTodosTratamientos() {
        return tratamientoRepository.findAll();
    }

    @Override
    public Tratamiento obtenerTratamientoPorId(Integer id) {
        return tratamientoRepository.findById(id).orElse(null);
    }

    @Override
    public long contarTratamientosUltimos30Dias() {
        Calendar calendar = Calendar.getInstance();
        Date fechaFin = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date fechaInicio = calendar.getTime();
        
        return tratamientoRepository.countByFechaBetween(fechaInicio, fechaFin);
    }

    @Override
    public List<Tratamiento> obtenerTratamientosUltimos30Dias() {
        Calendar calendar = Calendar.getInstance();
        Date fechaFin = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date fechaInicio = calendar.getTime();
        
        return tratamientoRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

    @Override
    public Map<String, Integer> obtenerMedicamentosMasUsadosUltimos30Dias() {
        Calendar calendar = Calendar.getInstance();
        Date fechaFin = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date fechaInicio = calendar.getTime();
        
        List<Object[]> resultados = tratamientoRepository.findMedicamentosMasUsados(fechaInicio, fechaFin);
        
        Map<String, Integer> medicamentosMap = new LinkedHashMap<>();
        for (Object[] resultado : resultados) {
            medicamentosMap.put((String) resultado[0], ((Number) resultado[1]).intValue());
        }
        
        return medicamentosMap;
    }

    @Override
    public List<Map<String, Object>> obtenerTop3MedicamentosMasVendidos() {
        return tratamientoRepository.findTop3MedicamentosMasVendidos();
    }
}