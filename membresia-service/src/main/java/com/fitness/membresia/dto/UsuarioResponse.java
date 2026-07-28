package com.fitness.membresia.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioResponse {
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;
}
