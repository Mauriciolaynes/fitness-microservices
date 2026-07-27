package com.fitness.rutina.mapper;

import com.fitness.rutina.dto.RutinaDTO;
import com.fitness.rutina.entity.Rutina;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RutinaMapper {
    RutinaDTO toDTO(Rutina rutina);
    Rutina toEntity(RutinaDTO dto);
    List<RutinaDTO> toDTOList(List<Rutina> rutinas);
}
