package com.fitness.ejercicio.service.impl;

import com.fitness.ejercicio.client.RutinaClient;
import com.fitness.ejercicio.dto.EjercicioRutinaDTO;
import com.fitness.ejercicio.entity.EjercicioRutina;
import com.fitness.ejercicio.mapper.EjercicioRutinaMapper;
import com.fitness.ejercicio.repository.EjercicioRutinaRepository;
import com.fitness.ejercicio.service.EjercicioRutinaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EjercicioRutinaServiceImpl implements EjercicioRutinaService {

    private final EjercicioRutinaRepository repository;
    private final EjercicioRutinaMapper mapper;
    private final RutinaClient rutinaClient;

    @Override
    public EjercicioRutinaDTO crear(EjercicioRutinaDTO dto) {
        // Comunicacion Feign: valida existencia en rutina-service
        Boolean existe = rutinaClient.existeRutina(dto.getIdRutina());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe la rutina con id: " + dto.getIdRutina());
        }
        EjercicioRutina entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public EjercicioRutinaDTO actualizar(Integer id, EjercicioRutinaDTO dto) {
        EjercicioRutina existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ejercicio no encontrado con id: " + id));

        Boolean existe = rutinaClient.existeRutina(dto.getIdRutina());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe la rutina con id: " + dto.getIdRutina());
        }

        existente.setNombre(dto.getNombre());
        existente.setSeries(dto.getSeries());
        existente.setIdRutina(dto.getIdRutina());
        return mapper.toDTO(repository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public EjercicioRutinaDTO obtenerPorId(Integer id) {
        EjercicioRutina entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ejercicio no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EjercicioRutinaDTO> listar() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EjercicioRutinaDTO> listarPorRutina(Integer idRutina) {
        return mapper.toDTOList(repository.findByIdRutina(idRutina));
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Ejercicio no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}
