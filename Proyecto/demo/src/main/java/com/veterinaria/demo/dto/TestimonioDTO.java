package com.veterinaria.demo.dto;

import com.veterinaria.demo.entidad.Testimonio;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class TestimonioDTO {
    private Integer idTestimonio;
    private String texto;
    private Integer calificacion;
    private String fecha;
    private String nombreCliente;
    private String imagenCliente;
    private String nombreServicio;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public TestimonioDTO() {
    }

    public TestimonioDTO(Testimonio testimonio) {
        this.idTestimonio = testimonio.getIdTestimonio();
        this.texto = testimonio.getTexto();
        this.calificacion = testimonio.getCalificacion();
        this.fecha = formatDate(testimonio.getFecha());
        this.nombreCliente = testimonio.getCliente().getNombre();
        this.imagenCliente = testimonio.getCliente().getFoto();
        this.nombreServicio = testimonio.getServicio().getNombre();
    }

    private String formatDate(Date date) {
        return date != null ? dateFormat.format(date) : "Sin fecha";
    }
}