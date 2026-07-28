package com.fitness.membresia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MembresiaDTO {
    private Integer id;

    @NotBlank(message = "El plan no puede estar vacio")
    private String plan;

    @NotNull(message = "La fecha de inicio es requerida")
    private LocalDate inicio;

    @NotNull(message = "La fecha de vencimiento es requerida")
    private LocalDate fin;

    @NotBlank(message = "El estado no puede estar vacio")
    private String estado;

    @NotNull(message = "El costo es requerido")
    private Double costo;

    @NotNull(message = "El id de usuario es requerido")
    private Integer idUsuario;
}
