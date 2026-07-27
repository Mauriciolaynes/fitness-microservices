package com.fitness.progreso.service;

import com.fitness.progreso.dto.ProgresoDTO;

import java.util.List;

public interface ProgresoService {
    ProgresoDTO crear(ProgresoDTO dto);
    ProgresoDTO actualizar(Integer id, ProgresoDTO dto);
    ProgresoDTO obtenerPorId(Integer id);
    List<ProgresoDTO> listar();
    List<ProgresoDTO> listarPorUsuario(Integer idUsuario);
    void eliminar(Integer id);
}
