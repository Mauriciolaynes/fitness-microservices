package com.fitness.usuario.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembresiaDTO {

    private Integer idMembresia;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal precio;
    private String tipoPlan;

    @NotNull(message = "El id de usuario es obligatorio")
    private Integer idUsuario;
}
