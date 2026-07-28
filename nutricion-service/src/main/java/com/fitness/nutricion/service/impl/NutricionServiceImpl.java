package com.fitness.nutricion.service.impl;

import com.fitness.nutricion.client.UsuarioClient;
import com.fitness.nutricion.dto.NutricionDTO;
import com.fitness.nutricion.entity.Nutricion;
import com.fitness.nutricion.mapper.NutricionMapper;
import com.fitness.nutricion.repository.NutricionRepository;
import com.fitness.nutricion.service.NutricionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NutricionServiceImpl implements NutricionService {

    private final NutricionRepository repository;
    private final NutricionMapper mapper;
    private final UsuarioClient usuarioClient;

    @Override
    public NutricionDTO crear(NutricionDTO dto) {
        // Comunicacion Feign: valida existencia de usuario en usuario-service
        Boolean existe = usuarioClient.existeUsuario(dto.getIdUsuario());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe el usuario con id: " + dto.getIdUsuario());
        }
        Nutricion entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public NutricionDTO actualizar(Integer id, NutricionDTO dto) {
        Nutricion existente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan de nutricion no encontrado con id: " + id));

        Boolean existe = usuarioClient.existeUsuario(dto.getIdUsuario());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe el usuario con id: " + dto.getIdUsuario());
        }

        existente.setPlanDetalle(dto.getPlanDetalle());
        existente.setCaloriasDiarias(dto.getCaloriasDiarias());
        existente.setObjetivo(dto.getObjetivo());
        existente.setIdUsuario(dto.getIdUsuario());
        return mapper.toDTO(repository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public NutricionDTO obtenerPorId(Integer id) {
        Nutricion entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan de nutricion no encontrado con id: " + id));
        return mapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NutricionDTO> listar() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NutricionDTO> listarPorUsuario(Integer idUsuario) {
        return mapper.toDTOList(repository.findByIdUsuario(idUsuario));
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Plan de nutricion no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}
