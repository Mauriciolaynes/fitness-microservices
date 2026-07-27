package com.fitness.rutina.mapper;

import com.fitness.rutina.dto.EjercicioRutinaDTO;
import com.fitness.rutina.entity.EjercicioRutina;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EjercicioRutinaMapper {
    EjercicioRutinaDTO toDTO(EjercicioRutina entity);
    EjercicioRutina toEntity(EjercicioRutinaDTO dto);
    List<EjercicioRutinaDTO> toDTOList(List<EjercicioRutina> lista);
}
