package com.veterinaria.demo.entidad;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veterinario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeterinario;

    private String nombre;
    private String cedula;
    private String especialidad;
    private String foto;
    private Integer estado;
    private Integer numeroAtenciones;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Cita> citas;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamientos;

    @ManyToOne
    @JoinColumn(name = "idRegistro", nullable = false)
    private Registro registro;
}