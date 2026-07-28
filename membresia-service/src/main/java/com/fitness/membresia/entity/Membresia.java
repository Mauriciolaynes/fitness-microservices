package com.fitness.membresia.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "membresia")
@Data
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plan")
    private String plan;

    @Column(name = "inicio")
    private LocalDate inicio;

    @Column(name = "fin")
    private LocalDate fin;

    @Column(name = "estado")
    private String estado;

    @Column(name = "costo")
    private Double costo;

    @Column(name = "usuario_id")
    private Integer idUsuario;
}
