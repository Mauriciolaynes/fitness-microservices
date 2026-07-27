package com.fitness.usuario.mapper;

import com.fitness.usuario.dto.MembresiaDTO;
import com.fitness.usuario.entity.Membresia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MembresiaMapper {

    MembresiaDTO toDTO(Membresia membresia);

    Membresia toEntity(MembresiaDTO membresiaDTO);

    List<MembresiaDTO> toDTOList(List<Membresia> membresias);
}
