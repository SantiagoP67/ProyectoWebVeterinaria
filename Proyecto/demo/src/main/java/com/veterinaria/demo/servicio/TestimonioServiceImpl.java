package com.veterinaria.demo.servicio;

import com.veterinaria.demo.entidad.Testimonio;
import com.veterinaria.demo.repositorio.TestimonioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonioServiceImpl implements TestimonioService {
    
    private final TestimonioRepository testimonioRepository;
    
    public TestimonioServiceImpl(TestimonioRepository testimonioRepository) {
        this.testimonioRepository = testimonioRepository;
    }
    
    @Override
    public List<Testimonio> obtenerTodosTestimonios() {
        return testimonioRepository.findAllWithClientAndService();
    }
}