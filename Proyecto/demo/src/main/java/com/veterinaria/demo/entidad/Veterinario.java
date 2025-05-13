package com.veterinaria.demo.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veterinario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeterinario;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String cedula;
    @Column(nullable = false)
    private String especialidad;
    @Column(nullable = false)
    private String foto;
    @Column(nullable = false)
    private String sede;
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 1")
    private Integer estado;
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer numeroAtenciones;

    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @Transient
    @Column(name = "contrasenha", nullable = false)
    private String contrasena;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cita> citas;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tratamiento> tratamientos;

    public Veterinario(String nombre, String cedula, String especialidad, String foto, String sede, String nombreUsuario, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.foto = foto;
        this.sede = sede;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
}