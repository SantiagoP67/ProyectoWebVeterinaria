package com.veterinaria.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.demo.entidad.Mascota;
import com.veterinaria.demo.entidad.Veterinario;
import com.veterinaria.demo.repositorio.TratamientoRepository;
import com.veterinaria.demo.repositorio.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {
    
    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public List<Veterinario> obtenerTodosVeterinarios() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario obtenerVeterinarioPorId(Integer id) {
        return veterinarioRepository.findById(id).orElse(null);
    }

    @Override
    public Veterinario crearVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario editarVeterinario(Integer id, Veterinario veterinario) {
        return veterinarioRepository.findById(id).map(veterinarioActual -> {
            veterinarioActual.setNombre(veterinario.getNombre());
            veterinarioActual.setCedula(veterinario.getCedula());
            veterinarioActual.setEspecialidad(veterinario.getEspecialidad());
            veterinarioActual.setNombreUsuario(veterinario.getNombreUsuario());
            veterinarioActual.setContrasena(veterinario.getContrasena());
            veterinarioActual.setFoto(veterinario.getFoto());
            veterinarioActual.setSede(veterinario.getSede());
            return veterinarioRepository.save(veterinarioActual);
        }).orElse(null);
    }

    @Override
    public void eliminarVeterinario(Integer id) {
        if (veterinarioRepository.existsById(id)) {
            veterinarioRepository.deleteById(id);
        }
    }

    @Override
    public Veterinario validarVeterinario(String username, String password) {
        return veterinarioRepository.findByNombreUsuarioAndContrasena(username, password);
    }

    @Override 
    public List<Mascota> obtenerMascotasAtendidas(Integer idVeterinario) {
        return tratamientoRepository.findMascotasByVeterinarioId(idVeterinario);
    }

    @Override
    public List<Veterinario> obtenerVeterinariosPorSede(String sede) {
        return veterinarioRepository.findBySedeAndEstado(sede, 1);
    }

    @Override
    public Veterinario obtenerVeterinarioConMenorAtencionesPorSede(String sede) {
        return veterinarioRepository.findTopBySedeAndEstadoOrderByNumeroAtencionesAsc(sede, 1);
    }
}