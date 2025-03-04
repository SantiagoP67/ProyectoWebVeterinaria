package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "TipoUsuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoUsuario")
    private Integer id;

    @Column(name = "nombreTipo", nullable = false)
    private String nombreTipo;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<Registro> registros;
}