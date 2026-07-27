package com.fitness.progreso.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponse {
    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String correo;
}
