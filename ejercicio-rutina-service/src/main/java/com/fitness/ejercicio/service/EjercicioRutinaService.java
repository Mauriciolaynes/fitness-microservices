package com.fitness.ejercicio.service;

import com.fitness.ejercicio.dto.EjercicioRutinaDTO;

import java.util.List;

public interface EjercicioRutinaService {
    EjercicioRutinaDTO crear(EjercicioRutinaDTO dto);
    EjercicioRutinaDTO actualizar(Integer id, EjercicioRutinaDTO dto);
    EjercicioRutinaDTO obtenerPorId(Integer id);
    List<EjercicioRutinaDTO> listar();
    List<EjercicioRutinaDTO> listarPorRutina(Integer idRutina);
    void eliminar(Integer id);
}
