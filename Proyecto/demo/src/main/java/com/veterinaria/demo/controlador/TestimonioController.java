package com.veterinaria.demo.controlador;

import com.veterinaria.demo.DTO.TestimonioDTO;
import com.veterinaria.demo.servicio.TestimonioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/testimonios")
@CrossOrigin(origins = "http://localhost:4200")
public class TestimonioController {
    
    private final TestimonioService testimonioService;
    
    public TestimonioController(TestimonioService testimonioService) {
        this.testimonioService = testimonioService;
    }
    
    @GetMapping
    public ResponseEntity<List<TestimonioDTO>> obtenerTodosTestimonios() {
        List<TestimonioDTO> testimonios = testimonioService.obtenerTodosTestimonios();
        return ResponseEntity.ok(testimonios);
    }
}