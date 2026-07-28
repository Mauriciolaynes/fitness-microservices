package com.fitness.ejercicio.mapper;

import com.fitness.ejercicio.dto.EjercicioRutinaDTO;
import com.fitness.ejercicio.entity.EjercicioRutina;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EjercicioRutinaMapper {

    public EjercicioRutinaDTO toDTO(EjercicioRutina entity) {
        if (entity == null) return null;
        EjercicioRutinaDTO dto = new EjercicioRutinaDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setSeries(entity.getSeries());
        dto.setIdRutina(entity.getIdRutina());
        return dto;
    }

    public EjercicioRutina toEntity(EjercicioRutinaDTO dto) {
        if (dto == null) return null;
        EjercicioRutina entity = new EjercicioRutina();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setSeries(dto.getSeries());
        entity.setIdRutina(dto.getIdRutina());
        return entity;
    }

    public List<EjercicioRutinaDTO> toDTOList(List<EjercicioRutina> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
