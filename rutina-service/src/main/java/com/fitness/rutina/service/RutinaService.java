package com.fitness.rutina.service;

import com.fitness.rutina.dto.RutinaDTO;

import java.util.List;

public interface RutinaService {
    RutinaDTO crear(RutinaDTO dto);
    RutinaDTO actualizar(Integer id, RutinaDTO dto);
    RutinaDTO obtenerPorId(Integer id);
    List<RutinaDTO> listar();
    List<RutinaDTO> listarPorUsuario(Integer idUsuario);
    boolean existe(Integer id);
    void eliminar(Integer id);
}
