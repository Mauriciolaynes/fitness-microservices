package com.fitness.usuario.service;

import com.fitness.usuario.dto.MembresiaDTO;

import java.util.List;

public interface MembresiaService {
    MembresiaDTO crear(MembresiaDTO dto);
    MembresiaDTO actualizar(Integer id, MembresiaDTO dto);
    MembresiaDTO obtenerPorId(Integer id);
    List<MembresiaDTO> listar();
    List<MembresiaDTO> listarPorUsuario(Integer idUsuario);
    void eliminar(Integer id);
}
