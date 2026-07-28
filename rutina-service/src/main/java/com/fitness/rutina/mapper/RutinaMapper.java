package com.fitness.rutina.mapper;

import com.fitness.rutina.dto.RutinaDTO;
import com.fitness.rutina.entity.Rutina;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RutinaMapper {

    public RutinaDTO toDTO(Rutina entity) {
        if (entity == null) return null;
        RutinaDTO dto = new RutinaDTO();
        dto.setIdRutina(entity.getIdRutina());
        dto.setNombreRutina(entity.getNombreRutina());
        dto.setIdUsuario(entity.getIdUsuario());
        return dto;
    }

    public Rutina toEntity(RutinaDTO dto) {
        if (dto == null) return null;
        Rutina entity = new Rutina();
        entity.setIdRutina(dto.getIdRutina());
        entity.setNombreRutina(dto.getNombreRutina());
        entity.setIdUsuario(dto.getIdUsuario());
        return entity;
    }

    public List<RutinaDTO> toDTOList(List<Rutina> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
