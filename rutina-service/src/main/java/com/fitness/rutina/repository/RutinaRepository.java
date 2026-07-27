package com.fitness.rutina.repository;

import com.fitness.rutina.entity.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaRepository extends JpaRepository<Rutina, Integer> {
    List<Rutina> findByIdUsuario(Integer idUsuario);
}
