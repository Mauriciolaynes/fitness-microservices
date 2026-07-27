package com.fitness.progreso.repository;

import com.fitness.progreso.entity.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgresoRepository extends JpaRepository<Progreso, Integer> {
    List<Progreso> findByIdUsuarioOrderByFechaRegistroAsc(Integer idUsuario);
}
