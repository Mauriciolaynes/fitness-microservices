package com.fitness.ejercicio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ejercicio_rutina")
@Data
public class EjercicioRutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "series")
    private Integer series;

    @Column(name = "rutina_id")
    private Integer idRutina;
}
