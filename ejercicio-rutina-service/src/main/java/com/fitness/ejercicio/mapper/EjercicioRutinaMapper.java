package com.fitness.ejercicio.mapper;

import com.fitness.ejercicio.dto.EjercicioRutinaDTO;
import com.fitness.ejercicio.entity.EjercicioRutina;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EjercicioRutinaMapper {

    EjercicioRutinaDTO toDTO(EjercicioRutina entity);

    EjercicioRutina toEntity(EjercicioRutinaDTO dto);

    List<EjercicioRutinaDTO> toDTOList(List<EjercicioRutina> entities);
}
