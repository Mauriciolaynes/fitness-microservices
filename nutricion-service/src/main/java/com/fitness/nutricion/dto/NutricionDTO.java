package com.fitness.nutricion.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NutricionDTO {
    private Integer id;

    @NotBlank(message = "El detalle del plan no puede estar vacio")
    private String planDetalle;

    @NotNull(message = "Las calorias diarias son requeridas")
    @Min(value = 500, message = "Debe haber al menos 500 calorias")
    private Integer caloriasDiarias;

    @NotBlank(message = "El objetivo no puede estar vacio")
    private String objetivo;

    @NotNull(message = "El id de usuario es requerido")
    private Integer idUsuario;
}
