package com.veterinaria.demo.servicio;

import com.veterinaria.demo.dto.TestimonioDTO;
import com.veterinaria.demo.entidad.Testimonio;
import com.veterinaria.demo.repositorio.TestimonioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonioServiceImpl implements TestimonioService {
    
    private final TestimonioRepository testimonioRepository;
    
    public TestimonioServiceImpl(TestimonioRepository testimonioRepository) {
        this.testimonioRepository = testimonioRepository;
    }
    
    @Override
    public List<TestimonioDTO> obtenerTodosTestimonios() {
        List<Testimonio> testimonios = testimonioRepository.findAllWithClientAndService();
        return testimonios.stream()
                        .map(this::convertToDTO)
                        .collect(Collectors.toList());
    }
    
    private TestimonioDTO convertToDTO(Testimonio testimonio) {
        TestimonioDTO dto = new TestimonioDTO();
        dto.setIdTestimonio(testimonio.getIdTestimonio());
        dto.setTexto(testimonio.getTexto());
        dto.setCalificacion(testimonio.getCalificacion());
        dto.setFecha(testimonio.getFecha().toString());
        
        if(testimonio.getCliente() != null) {
            dto.setNombreCliente(testimonio.getCliente().getNombre());
            dto.setImagenCliente(testimonio.getCliente().getFoto());
        }
        
        if(testimonio.getServicio() != null) {
            dto.setNombreServicio(testimonio.getServicio().getNombre());
        }
        
        return dto;
    }
}