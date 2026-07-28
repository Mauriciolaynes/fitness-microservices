package com.fitness.nutricion.repository;

import com.fitness.nutricion.entity.Nutricion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutricionRepository extends JpaRepository<Nutricion, Integer> {
    List<Nutricion> findByIdUsuario(Integer idUsuario);
}
