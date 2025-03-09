package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Administrador ;
import com.veterinaria.demo.repositorio.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl implements AdministradorService{
    @Autowired
    AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> obtenerTodosAdministradors() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador obtenerAdministradorPorId(Integer id) {
        return administradorRepository.findById(id).orElse(null);
    }

    @Override
    public Administrador crearAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador editarAdministrador(Integer id, Administrador administrador) {
        Administrador administradoractual = administradorRepository.findById(id).orElse(null);
        administradoractual.setNombre(administrador.getNombre());
        administradoractual.setCedula( administrador.getCedula());
        administradoractual.setNombreUsuario(administrador.getNombreUsuario());
        administradoractual.setContrasena( administrador.getContrasena());
        administradoractual.setCorreo( administrador.getCorreo());
        administradoractual.setFoto( administrador.getFoto());
        return administradorRepository.save(administradoractual);
    }

    @Override
    public void eliminarAdministrador(Integer id) {
        administradorRepository.deleteById(id);
    }

    @Override
    public Administrador validarAdministrador(String username, String password) {
        return administradorRepository.findByNombreUsuarioAndContrasena(username, password);
    }
}