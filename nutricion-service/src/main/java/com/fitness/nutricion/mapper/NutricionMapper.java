package com.fitness.nutricion.mapper;

import com.fitness.nutricion.dto.NutricionDTO;
import com.fitness.nutricion.entity.Nutricion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NutricionMapper {

    NutricionDTO toDTO(Nutricion entity);

    Nutricion toEntity(NutricionDTO dto);

    List<NutricionDTO> toDTOList(List<Nutricion> entities);
}
