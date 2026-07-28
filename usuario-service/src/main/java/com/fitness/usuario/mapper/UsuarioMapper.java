package com.fitness.usuario.mapper;

import com.fitness.usuario.dto.UsuarioDTO;
import com.fitness.usuario.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario entity) {
        if (entity == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNombres(entity.getNombres());
        dto.setApellidos(entity.getApellidos());
        dto.setCorreo(entity.getCorreo());
        dto.setDni(entity.getDni());
        dto.setPassword(entity.getPassword());
        dto.setRol(entity.getRol());
        dto.setTelefono(entity.getTelefono());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;
        Usuario entity = new Usuario();
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setNombres(dto.getNombres());
        entity.setApellidos(dto.getApellidos());
        entity.setCorreo(dto.getCorreo());
        entity.setDni(dto.getDni());
        entity.setPassword(dto.getPassword());
        entity.setRol(dto.getRol());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }

    public List<UsuarioDTO> toDTOList(List<Usuario> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
