package com.fitness.rutina.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rutina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina")
    private Integer idRutina;

    @Column(name = "nombre_rutina", length = 50, nullable = false)
    private String nombreRutina;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
}
