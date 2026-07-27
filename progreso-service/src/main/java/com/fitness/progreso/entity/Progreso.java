package com.fitness.progreso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "progreso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progreso")
    private Integer idProgreso;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "peso", precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
}
