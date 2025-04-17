package com.veterinaria.demo.DTO;

import java.util.Date;

public class CitaDTO {
    private Integer idCita;
    private Date fechaHora;
    private String sede;
    private String nombreMascota;
    private String nombreCliente;
    private String nombreServicio;
    private String nombreVeterinario;
    
    // Getters y Setters
    public Integer getIdCita() {
        return idCita;
    }
    
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    
    public Date getFechaHora() {
        return fechaHora;
    }
    
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public String getSede() {
        return sede;
    }
    
    public void setSede(String sede) {
        this.sede = sede;
    }
    
    public String getNombreMascota() {
        return nombreMascota;
    }
    
    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public String getNombreServicio() {
        return nombreServicio;
    }
    
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
    
    public String getNombreVeterinario() {
        return nombreVeterinario;
    }
    
    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }
}