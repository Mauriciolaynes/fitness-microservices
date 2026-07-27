package com.fitness.rutina.dto;

import lombok.*;

/**
 * DTO liviano para representar la respuesta que devuelve usuario-service
 * al ser consultado via Feign (comunicacion entre microservicios).
 */
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
