package com.veterinaria.demo.servicio;

import java.util.List;

import com.veterinaria.demo.DTO.TestimonioDTO;

public interface TestimonioService {
    List<TestimonioDTO> obtenerTodosTestimonios();
}