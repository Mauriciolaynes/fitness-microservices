package com.fitness.membresia.mapper;

import com.fitness.membresia.dto.MembresiaDTO;
import com.fitness.membresia.entity.Membresia;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MembresiaMapper {

    public MembresiaDTO toDTO(Membresia entity) {
        if (entity == null) return null;
        MembresiaDTO dto = new MembresiaDTO();
        dto.setId(entity.getId());
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setPlan(entity.getPlan());
        dto.setCosto(entity.getCosto());
        dto.setInicio(entity.getInicio());
        dto.setFin(entity.getFin());
        dto.setEstado(entity.getEstado());
        return dto;
    }

    public Membresia toEntity(MembresiaDTO dto) {
        if (dto == null) return null;
        Membresia entity = new Membresia();
        entity.setId(dto.getId());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setPlan(dto.getPlan());
        entity.setCosto(dto.getCosto());
        entity.setInicio(dto.getInicio());
        entity.setFin(dto.getFin());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public List<MembresiaDTO> toDTOList(List<Membresia> entities) {
        if (entities == null) return List.of();
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
