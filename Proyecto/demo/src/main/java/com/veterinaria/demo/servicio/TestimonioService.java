package com.veterinaria.demo.servicio;

import com.veterinaria.demo.dto.TestimonioDTO;
import java.util.List;

public interface TestimonioService {
    List<TestimonioDTO> obtenerTodosTestimonios();
}