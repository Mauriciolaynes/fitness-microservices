package com.fitness.ejercicio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EjercicioRutinaDTO {
    private Integer id;

    @NotBlank(message = "El nombre del ejercicio no puede estar vacio")
    private String nombre;

    @NotNull(message = "La cantidad de series es requerida")
    @Min(value = 1, message = "Debe haber al menos 1 serie")
    private Integer series;

    @NotNull(message = "El id de rutina es requerido")
    private Integer idRutina;
}
