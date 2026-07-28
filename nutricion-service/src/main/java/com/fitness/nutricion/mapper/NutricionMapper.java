package com.fitness.nutricion.mapper;

import com.fitness.nutricion.dto.NutricionDTO;
import com.fitness.nutricion.entity.Nutricion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NutricionMapper {

    public NutricionDTO toDTO(Nutricion entity) {
        if (entity == null) return null;
        NutricionDTO dto = new NutricionDTO();
        dto.setId(entity.getId());
        dto.setPlanDetalle(entity.getPlanDetalle());
        dto.setCaloriasDiarias(entity.getCaloriasDiarias());
        dto.setObjetivo(entity.getObjetivo());
        dto.setIdUsuario(entity.getIdUsuario());
        return dto;
    }

    public Nutricion toEntity(NutricionDTO dto) {
        if (dto == null) return null;
        Nutricion entity = new Nutricion();
        entity.setId(dto.getId());
        entity.setPlanDetalle(dto.getPlanDetalle());
        entity.setCaloriasDiarias(dto.getCaloriasDiarias());
        entity.setObjetivo(dto.getObjetivo());
        entity.setIdUsuario(dto.getIdUsuario());
        return entity;
    }

    public List<NutricionDTO> toDTOList(List<Nutricion> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
