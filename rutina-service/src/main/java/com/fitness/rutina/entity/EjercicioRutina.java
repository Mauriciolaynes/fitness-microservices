package com.fitness.rutina.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ejercicio_rutina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EjercicioRutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Integer idEjercicio;

    @Column(name = "nombre_ejercicio", length = 50, nullable = false)
    private String nombreEjercicio;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    @Column(name = "series")
    private Integer series;

    @Column(name = "id_rutina", nullable = false)
    private Integer idRutina;
}
