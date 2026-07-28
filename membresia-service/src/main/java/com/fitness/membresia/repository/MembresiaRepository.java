package com.fitness.membresia.repository;

import com.fitness.membresia.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    List<Membresia> findByIdUsuario(Integer idUsuario);
}
