package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrador;

    private String nombre;

    @Column(name = "cedula", unique = true)
    private String cedula;

    @Column(name = "nombreUsuario", unique = true)
    private String nombreUsuario;

    @Column(name = "contrasenha", unique = true)
    private String contrasena;
}