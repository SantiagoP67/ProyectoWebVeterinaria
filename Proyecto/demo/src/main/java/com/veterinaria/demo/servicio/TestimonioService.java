package com.veterinaria.demo.servicio;

import java.util.List;

import com.veterinaria.demo.dto.TestimonioDTO;

public interface TestimonioService {
    List<TestimonioDTO> obtenerTodosTestimonios();
}