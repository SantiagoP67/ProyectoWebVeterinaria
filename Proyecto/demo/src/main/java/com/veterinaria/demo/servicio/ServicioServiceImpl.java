package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Servicio;
import com.veterinaria.demo.repositorio.ServicioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements ServicioService {
    
    private final ServicioRepository servicioRepository;
    
    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }
    
    @Override
    public List<Servicio> obtenerTodosServicios() {
        return servicioRepository.findAllByOrderByNombreAsc();
    }
}