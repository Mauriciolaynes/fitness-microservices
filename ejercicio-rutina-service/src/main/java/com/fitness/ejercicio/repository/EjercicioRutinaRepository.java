package com.fitness.ejercicio.repository;

import com.fitness.ejercicio.entity.EjercicioRutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjercicioRutinaRepository extends JpaRepository<EjercicioRutina, Integer> {
    List<EjercicioRutina> findByIdRutina(Integer idRutina);
}
