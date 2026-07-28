package com.fitness.nutricion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "nutricion")
@Data
public class Nutricion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plan_detalle")
    private String planDetalle;

    @Column(name = "calorias_diarias")
    private Integer caloriasDiarias;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "usuario_id")
    private Integer idUsuario;
}
