package com.fitness.usuario.service.impl;

import com.fitness.usuario.dto.UsuarioDTO;
import com.fitness.usuario.entity.Usuario;
import com.fitness.usuario.mapper.UsuarioMapper;
import com.fitness.usuario.repository.UsuarioRepository;
import com.fitness.usuario.service.UsuarioService;
import com.fitness.usuario.exception.UsuarioNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO crear(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setIdUsuario(null);
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(guardado);
    }

    @Override
    public UsuarioDTO actualizar(Integer id, UsuarioDTO dto) {
        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));

        existente.setNombres(dto.getNombres());
        existente.setApellidos(dto.getApellidos());
        existente.setCorreo(dto.getCorreo());
        existente.setDni(dto.getDni());
        existente.setPassword(dto.getPassword());
        existente.setRol(dto.getRol());
        existente.setTelefono(dto.getTelefono());

        return usuarioMapper.toDTO(usuarioRepository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO obtenerPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listar() {
        return usuarioMapper.toDTOList(usuarioRepository.findAll());
    }

    @Override
    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existe(Integer id) {
        return usuarioRepository.existsById(id);
    }
}
