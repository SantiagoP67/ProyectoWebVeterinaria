package com.veterinaria.demo.entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veterinario")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer estado;
    @Column(nullable = false)
    private Integer numeroAtenciones;

    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasenha", unique = true, nullable = false)
    private String contrasena;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Cita> citas;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamientos;
}