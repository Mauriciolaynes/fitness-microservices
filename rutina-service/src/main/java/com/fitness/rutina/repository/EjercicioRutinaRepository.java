package com.fitness.rutina.repository;

import com.fitness.rutina.entity.EjercicioRutina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EjercicioRutinaRepository extends JpaRepository<EjercicioRutina, Integer> {
    List<EjercicioRutina> findByIdRutina(Integer idRutina);
}
