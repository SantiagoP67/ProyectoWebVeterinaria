package com.veterinaria.demo.dto;

import com.veterinaria.demo.entidad.Testimonio;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Integer getIdTestimonio() {
        return idTestimonio;
    }

    public void setIdTestimonio(Integer idTestimonio) {
        this.idTestimonio = idTestimonio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getImagenCliente() {
        return imagenCliente;
    }

    public void setImagenCliente(String imagenCliente) {
        this.imagenCliente = imagenCliente;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
}