package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "registro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

    @Id
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    private String password;

    @ManyToOne
    @JoinColumn(name = "idTipoUsuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "registro", cascade = CascadeType.ALL)
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "registro", cascade = CascadeType.ALL)
    private List<Veterinario> veterinarios;

    @OneToMany(mappedBy = "registro", cascade = CascadeType.ALL)
    private List<Administrador> administradores;
}