package com.veterinaria.demo.servicio;

import com.veterinaria.demo.repositorio.MedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicamentoServiceImpl implements MedicamentoService{
    @Autowired
    MedicamentoRepository medicamentoRepository;

   /* @Override
    public Medicamento SearchById(int id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medicamento> SearchAll() {
        return medicamentoRepository.findAll();
    }*/

}