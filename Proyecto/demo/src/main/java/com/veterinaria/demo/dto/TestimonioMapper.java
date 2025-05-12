package com.veterinaria.demo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.veterinaria.demo.entidad.Testimonio;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper
public interface TestimonioMapper {
    TestimonioMapper INSTANCE = Mappers.getMapper(TestimonioMapper.class);
    
    @Mapping(target = "nombreCliente", source = "cliente.nombre")
    @Mapping(target = "imagenCliente", source = "cliente.foto")
    @Mapping(target = "nombreServicio", source = "servicio.nombre")
    @Mapping(target = "fecha", source = "fecha", qualifiedByName = "formatDate")
    TestimonioDTO convert(Testimonio testimonio);
    
    @Named("formatDate")
    static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return date != null ? dateFormat.format(date) : "Sin fecha";
    }
}