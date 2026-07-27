package com.fitness.progreso.service.impl;

import com.fitness.progreso.client.UsuarioClient;
import com.fitness.progreso.dto.ProgresoDTO;
import com.fitness.progreso.entity.Progreso;
import com.fitness.progreso.mapper.ProgresoMapper;
import com.fitness.progreso.repository.ProgresoRepository;
import com.fitness.progreso.service.ProgresoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgresoServiceImpl implements ProgresoService {

    private final ProgresoRepository progresoRepository;
    private final ProgresoMapper progresoMapper;
    private final UsuarioClient usuarioClient;

    @Override
    public ProgresoDTO crear(ProgresoDTO dto) {
        Boolean existe = usuarioClient.existeUsuario(dto.getIdUsuario());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe el usuario con id: " + dto.getIdUsuario());
        }
        Progreso progreso = progresoMapper.toEntity(dto);
        progreso.setIdProgreso(null);
        return progresoMapper.toDTO(progresoRepository.save(progreso));
    }

    @Override
    public ProgresoDTO actualizar(Integer id, ProgresoDTO dto) {
        Progreso existente = progresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Progreso no encontrado con id: " + id));
        existente.setFechaRegistro(dto.getFechaRegistro());
        existente.setPeso(dto.getPeso());
        existente.setIdUsuario(dto.getIdUsuario());
        return progresoMapper.toDTO(progresoRepository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public ProgresoDTO obtenerPorId(Integer id) {
        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Progreso no encontrado con id: " + id));
        return progresoMapper.toDTO(progreso);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProgresoDTO> listar() {
        return progresoMapper.toDTOList(progresoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProgresoDTO> listarPorUsuario(Integer idUsuario) {
        return progresoMapper.toDTOList(progresoRepository.findByIdUsuarioOrderByFechaRegistroAsc(idUsuario));
    }

    @Override
    public void eliminar(Integer id) {
        if (!progresoRepository.existsById(id)) {
            throw new EntityNotFoundException("Progreso no encontrado con id: " + id);
        }
        progresoRepository.deleteById(id);
    }
}
