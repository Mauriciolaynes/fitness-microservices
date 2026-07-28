package com.fitness.membresia.service.impl;

import com.fitness.membresia.client.UsuarioClient;
import com.fitness.membresia.dto.MembresiaDTO;
import com.fitness.membresia.entity.Membresia;
import com.fitness.membresia.mapper.MembresiaMapper;
import com.fitness.membresia.repository.MembresiaRepository;
import com.fitness.membresia.service.MembresiaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MembresiaServiceImpl implements MembresiaService {

    private final MembresiaRepository membresiaRepository;
    private final MembresiaMapper membresiaMapper;
    private final UsuarioClient usuarioClient;

    @Override
    public MembresiaDTO crear(MembresiaDTO dto) {
        // Comunicacion Feign: valida existencia en usuario-service
        Boolean existe = usuarioClient.existeUsuario(dto.getIdUsuario());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe el usuario con id: " + dto.getIdUsuario());
        }
        Membresia entity = membresiaMapper.toEntity(dto);
        entity.setId(null);
        return membresiaMapper.toDTO(membresiaRepository.save(entity));
    }

    @Override
    public MembresiaDTO actualizar(Integer id, MembresiaDTO dto) {
        Membresia existente = membresiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membresia no encontrada con id: " + id));
        
        Boolean existe = usuarioClient.existeUsuario(dto.getIdUsuario());
        if (existe == null || !existe) {
            throw new EntityNotFoundException("No existe el usuario con id: " + dto.getIdUsuario());
        }

        existente.setPlan(dto.getPlan());
        existente.setInicio(dto.getInicio());
        existente.setFin(dto.getFin());
        existente.setEstado(dto.getEstado());
        existente.setCosto(dto.getCosto());
        existente.setIdUsuario(dto.getIdUsuario());
        return membresiaMapper.toDTO(membresiaRepository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public MembresiaDTO obtenerPorId(Integer id) {
        Membresia entity = membresiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membresia no encontrada con id: " + id));
        return membresiaMapper.toDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembresiaDTO> listar() {
        return membresiaMapper.toDTOList(membresiaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembresiaDTO> listarPorUsuario(Integer idUsuario) {
        return membresiaMapper.toDTOList(membresiaRepository.findByIdUsuario(idUsuario));
    }

    @Override
    public void eliminar(Integer id) {
        if (!membresiaRepository.existsById(id)) {
            throw new EntityNotFoundException("Membresia no encontrada con id: " + id);
        }
        membresiaRepository.deleteById(id);
    }
}
