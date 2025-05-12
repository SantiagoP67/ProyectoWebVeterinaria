package com.veterinaria.demo.dto;

import lombok.Data;
import java.util.Date;

@Data
public class CitaDTO {
    private Integer idCita;
    private Date fechaHora;
    private String sede;
    private String nombreMascota;
    private String nombreCliente;
    private String nombreServicio;
    private String nombreVeterinario;
}