package com.fitness.usuario.service;

import com.fitness.usuario.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO crear(UsuarioDTO dto);
    UsuarioDTO actualizar(Integer id, UsuarioDTO dto);
    UsuarioDTO obtenerPorId(Integer id);
    List<UsuarioDTO> listar();
    void eliminar(Integer id);
    boolean existe(Integer id);
}
