package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Medicamento;
import com.veterinaria.demo.repositorio.MedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}