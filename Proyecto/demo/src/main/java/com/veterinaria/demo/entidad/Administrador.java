package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "administrador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrador;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String foto;

    @Column(unique = true, nullable = false)
    private String cedula;

    @Column(unique = true, nullable = false)
    private String nombreUsuario;

    @Column(name = "contrasenha", unique = true, nullable = false)
    private String contrasena;
}