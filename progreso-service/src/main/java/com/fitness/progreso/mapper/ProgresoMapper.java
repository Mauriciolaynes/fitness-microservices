package com.fitness.progreso.mapper;

import com.fitness.progreso.dto.ProgresoDTO;
import com.fitness.progreso.entity.Progreso;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgresoMapper {
    ProgresoDTO toDTO(Progreso progreso);
    Progreso toEntity(ProgresoDTO dto);
    List<ProgresoDTO> toDTOList(List<Progreso> progresos);
}
