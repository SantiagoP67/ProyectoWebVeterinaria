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

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editarCliente(Integer id, Cliente cliente) {
        Cliente clienteactual = clienteRepository.findById(id).orElse(null);
        clienteactual.setNombre(cliente.getNombre());
        clienteactual.setCorreo(cliente.getCorreo());
        clienteactual.setCelular(cliente.getCelular());
        clienteactual.setCedula( cliente.getCedula());
        clienteactual.setNombreUsuario(cliente.getNombreUsuario());
        clienteactual.setContrasena( cliente.getContrasena());
        return clienteRepository.save(clienteactual);
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}