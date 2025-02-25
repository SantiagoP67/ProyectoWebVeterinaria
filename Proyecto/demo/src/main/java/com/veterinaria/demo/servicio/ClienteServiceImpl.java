package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Cliente; 
import com.veterinaria.demo.repositorio.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

   /* @Override
    public Cliente SearchById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> SearchAll() {
        return clienteRepository.findAll();
    }*/

}