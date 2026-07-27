package com.fitness.usuario.service.impl;

import com.fitness.usuario.dto.MembresiaDTO;
import com.fitness.usuario.entity.Membresia;
import com.fitness.usuario.mapper.MembresiaMapper;
import com.fitness.usuario.repository.MembresiaRepository;
import com.fitness.usuario.repository.UsuarioRepository;
import com.fitness.usuario.service.MembresiaService;
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
    private final UsuarioRepository usuarioRepository;
    private final MembresiaMapper membresiaMapper;

    @Override
    public MembresiaDTO crear(MembresiaDTO dto) {
        if (!usuarioRepository.existsById(dto.getIdUsuario())) {
            throw new EntityNotFoundException("No existe el usuario con id: " + dto.getIdUsuario());
        }
        Membresia membresia = membresiaMapper.toEntity(dto);
        membresia.setIdMembresia(null);
        return membresiaMapper.toDTO(membresiaRepository.save(membresia));
    }

    @Override
    public MembresiaDTO actualizar(Integer id, MembresiaDTO dto) {
        Membresia existente = membresiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membresia no encontrada con id: " + id));

        existente.setEstado(dto.getEstado());
        existente.setFechaInicio(dto.getFechaInicio());
        existente.setFechaFin(dto.getFechaFin());
        existente.setPrecio(dto.getPrecio());
        existente.setTipoPlan(dto.getTipoPlan());
        existente.setIdUsuario(dto.getIdUsuario());

        return membresiaMapper.toDTO(membresiaRepository.save(existente));
    }

    @Override
    @Transactional(readOnly = true)
    public MembresiaDTO obtenerPorId(Integer id) {
        Membresia membresia = membresiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membresia no encontrada con id: " + id));
        return membresiaMapper.toDTO(membresia);
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
