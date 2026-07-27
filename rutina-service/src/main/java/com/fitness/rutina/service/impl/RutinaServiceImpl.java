package com.fitness.rutina.service.impl;

import com.fitness.rutina.client.UsuarioClient;
import com.fitness.rutina.dto.RutinaDTO;
import com.fitness.rutina.entity.Rutina;
import com.fitness.rutina.mapper.RutinaMapper;
import com.fitness.rutina.repository.RutinaRepository;
import com.fitness.rutina.service.RutinaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RutinaServiceImpl implements RutinaService {

    private final RutinaRepository rutinaRepository;
    private final RutinaMapper rutinaMapper;
    private final UsuarioClient usuarioClient;

    @Override
    public RutinaDTO crear(RutinaDTO dto) {
        // Comunicacion entre microservicios: se valida contra usuario-service
        // que el usuario exista antes de registrar la rutina.
        Boolean existe = usuarioClient.existeUsuario(dto.getIdUsuario());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe el usuario con id: " + dto.getIdUsuario());
        }
        Rutina rutina = rutinaMapper.toEntity(dto);
        rutina.setIdRutina(null);
        return rutinaMapper.toDTO(rutinaRepository.save(rutina));
    }

    @Override
    public RutinaDTO actualizar(Integer id, RutinaDTO dto) {
        Rutina existente = rutinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rutina no encontrada con id: " + id));
        existente.setNombreRutina(dto.getNombreRutina());
        existente.setIdUsuario(dto.getIdUsuario());
        return rutinaMapper.toDTO(rutinaRepository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public RutinaDTO obtenerPorId(Integer id) {
        Rutina rutina = rutinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rutina no encontrada con id: " + id));
        return rutinaMapper.toDTO(rutina);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RutinaDTO> listar() {
        return rutinaMapper.toDTOList(rutinaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RutinaDTO> listarPorUsuario(Integer idUsuario) {
        return rutinaMapper.toDTOList(rutinaRepository.findByIdUsuario(idUsuario));
    }

    @Override
    public void eliminar(Integer id) {
        if (!rutinaRepository.existsById(id)) {
            throw new EntityNotFoundException("Rutina no encontrada con id: " + id);
        }
        rutinaRepository.deleteById(id);
    }
}
