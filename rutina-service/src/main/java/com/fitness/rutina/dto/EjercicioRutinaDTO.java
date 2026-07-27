package com.fitness.rutina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EjercicioRutinaDTO {
    private Integer idEjercicio;

    @NotBlank(message = "El nombre del ejercicio es obligatorio")
    private String nombreEjercicio;

    private Integer repeticiones;
    private Integer series;

    @NotNull(message = "El id de rutina es obligatorio")
    private Integer idRutina;
}
