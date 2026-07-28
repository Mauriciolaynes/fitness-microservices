package com.fitness.membresia.mapper;

import com.fitness.membresia.dto.MembresiaDTO;
import com.fitness.membresia.entity.Membresia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MembresiaMapper {

    MembresiaDTO toDTO(Membresia entity);

    Membresia toEntity(MembresiaDTO dto);

    List<MembresiaDTO> toDTOList(List<Membresia> entities);
}
