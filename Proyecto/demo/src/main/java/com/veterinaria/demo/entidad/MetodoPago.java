package com.veterinaria.demo.entidad;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "metodoPago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMetodoPago", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nombre;
}