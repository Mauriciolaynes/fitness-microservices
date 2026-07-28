package com.fitness.nutricion.service;

import com.fitness.nutricion.dto.NutricionDTO;

import java.util.List;

public interface NutricionService {
    NutricionDTO crear(NutricionDTO dto);
    NutricionDTO actualizar(Integer id, NutricionDTO dto);
    NutricionDTO obtenerPorId(Integer id);
    List<NutricionDTO> listar();
    List<NutricionDTO> listarPorUsuario(Integer idUsuario);
    void eliminar(Integer id);
}
