package com.fitness.progreso.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgresoDTO {
    private Integer idProgreso;

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDate fechaRegistro;

    @NotNull(message = "El peso es obligatorio")
    private BigDecimal peso;

    @NotNull(message = "El id de usuario es obligatorio")
    private Integer idUsuario;
}
