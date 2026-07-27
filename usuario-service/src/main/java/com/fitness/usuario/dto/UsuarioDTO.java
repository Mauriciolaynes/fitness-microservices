package com.fitness.usuario.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private Integer idUsuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50)
    private String apellidos;

    @NotBlank
    @Email(message = "Correo invalido")
    @Size(max = 100)
    private String correo;

    @NotBlank
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    private String dni;

    @NotBlank
    @Size(max = 255)
    private String password;

    @Size(max = 20)
    private String rol;

    @Size(max = 15)
    private String telefono;
}
