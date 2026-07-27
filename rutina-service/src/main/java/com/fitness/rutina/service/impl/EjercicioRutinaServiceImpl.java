package com.fitness.rutina.service.impl;

import com.fitness.rutina.dto.EjercicioRutinaDTO;
import com.fitness.rutina.entity.EjercicioRutina;
import com.fitness.rutina.mapper.EjercicioRutinaMapper;
import com.fitness.rutina.repository.EjercicioRutinaRepository;
import com.fitness.rutina.repository.RutinaRepository;
import com.fitness.rutina.service.EjercicioRutinaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EjercicioRutinaServiceImpl implements EjercicioRutinaService {

    private final EjercicioRutinaRepository ejercicioRutinaRepository;
    private final RutinaRepository rutinaRepository;
    private final EjercicioRutinaMapper ejercicioRutinaMapper;

    @Override
    public EjercicioRutinaDTO crear(EjercicioRutinaDTO dto) {
        if (!rutinaRepository.existsById(dto.getIdRutina())) {
            throw new EntityNotFoundException("No existe la rutina con id: " + dto.getIdRutina());
        }
        EjercicioRutina entity = ejercicioRutinaMapper.toEntity(dto);
        entity.setIdEjercicio(null);
        return ejercicioRutinaMapper.toDTO(ejercicioRutinaRepository.save(entity));
    }

    @Override
    public EjercicioRutinaDTO actualizar(Integer id, EjercicioRutinaDTO dto) {
        EjercicioRutina existente = ejercicioRutinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ejercicio no encontrado con id: " + id));
        existente.setNombreEjercicio(dto.getNombreEjercicio());
        existente.setRepeticiones(dto.getRepeticiones());
        existente.setSeries(dto.getSeries());
        existente.setIdRutina(dto.getIdRutina());
        return ejercicioRutinaMapper.toDTO(ejercicioRutinaRepository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public EjercicioRutinaDTO obtenerPorId(Integer id) {
        EjercicioRutina entity = ejercicioRutinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ejercicio no encontrado con id: " + id));
        return ejercicioRutinaMapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EjercicioRutinaDTO> listar() {
        return ejercicioRutinaMapper.toDTOList(ejercicioRutinaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EjercicioRutinaDTO> listarPorRutina(Integer idRutina) {
        return ejercicioRutinaMapper.toDTOList(ejercicioRutinaRepository.findByIdRutina(idRutina));
    }

    @Override
    public void eliminar(Integer id) {
        if (!ejercicioRutinaRepository.existsById(id)) {
            throw new EntityNotFoundException("Ejercicio no encontrado con id: " + id);
        }
        ejercicioRutinaRepository.deleteById(id);
    }
}
