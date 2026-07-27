package com.fitness.rutina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RutinaDTO {
    private Integer idRutina;

    @NotBlank(message = "El nombre de la rutina es obligatorio")
    private String nombreRutina;

    @NotNull(message = "El id de usuario es obligatorio")
    private Integer idUsuario;
}
