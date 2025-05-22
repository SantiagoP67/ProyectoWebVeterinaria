package com.veterinaria.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.demo.entidad.Medicamento;
import com.veterinaria.demo.repositorio.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> obtenerTodosTratamientos() {
        return medicamentoRepository.findAll();
    }

    @Override
    public Medicamento obtenerMedicamentoPorId(Integer id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

      @Override
    public List<Medicamento> buscarPorNombre(String nombre) {
        return medicamentoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}