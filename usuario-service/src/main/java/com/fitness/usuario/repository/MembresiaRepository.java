package com.fitness.usuario.repository;

import com.fitness.usuario.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    List<Membresia> findByIdUsuario(Integer idUsuario);
}
