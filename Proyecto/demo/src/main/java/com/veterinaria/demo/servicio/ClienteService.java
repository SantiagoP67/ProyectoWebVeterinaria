package com.veterinaria.demo.servicio;

import java.util.List;

import com.veterinaria.demo.entidad.Cliente;

public interface ClienteService{
    List<Cliente> obtenerTodosClientes();
    Cliente obtenerClientePorId(Integer id);
    Cliente crearCliente(Cliente cliente);
    Cliente editarCliente(Integer id, Cliente cliente);
    void eliminarCliente(Integer id);
    Cliente validarCliente(String username, String password);
}

