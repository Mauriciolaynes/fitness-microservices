package com.fitness.progreso.mapper;

import com.fitness.progreso.dto.ProgresoDTO;
import com.fitness.progreso.entity.Progreso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProgresoMapper {

    public ProgresoDTO toDTO(Progreso entity) {
        if (entity == null) return null;
        ProgresoDTO dto = new ProgresoDTO();
        dto.setIdProgreso(entity.getIdProgreso());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setPeso(entity.getPeso());
        dto.setIdUsuario(entity.getIdUsuario());
        return dto;
    }

    public Progreso toEntity(ProgresoDTO dto) {
        if (dto == null) return null;
        Progreso entity = new Progreso();
        entity.setIdProgreso(dto.getIdProgreso());
        entity.setFechaRegistro(dto.getFechaRegistro());
        entity.setPeso(dto.getPeso());
        entity.setIdUsuario(dto.getIdUsuario());
        return entity;
    }

    public List<ProgresoDTO> toDTOList(List<Progreso> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
