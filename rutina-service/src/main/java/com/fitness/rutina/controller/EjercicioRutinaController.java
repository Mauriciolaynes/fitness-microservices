package com.fitness.rutina.controller;

import com.fitness.rutina.dto.EjercicioRutinaDTO;
import com.fitness.rutina.service.EjercicioRutinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios-rutina")
@RequiredArgsConstructor
@Tag(name = "Ejercicios de rutina", description = "Gestion de ejercicios dentro de una rutina")
public class EjercicioRutinaController {

    private final EjercicioRutinaService ejercicioRutinaService;

    @Operation(summary = "Crear un ejercicio dentro de una rutina")
    @PostMapping
    public ResponseEntity<EjercicioRutinaDTO> crear(@Valid @RequestBody EjercicioRutinaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioRutinaService.crear(dto));
    }

    @Operation(summary = "Actualizar un ejercicio de rutina")
    @PutMapping("/{id}")
    public ResponseEntity<EjercicioRutinaDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody EjercicioRutinaDTO dto) {
        return ResponseEntity.ok(ejercicioRutinaService.actualizar(id, dto));
    }

    @Operation(summary = "Obtener un ejercicio de rutina por id")
    @GetMapping("/{id}")
    public ResponseEntity<EjercicioRutinaDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(ejercicioRutinaService.obtenerPorId(id));
    }

    @Operation(summary = "Listar todos los ejercicios de rutina")
    @GetMapping
    public ResponseEntity<List<EjercicioRutinaDTO>> listar() {
        return ResponseEntity.ok(ejercicioRutinaService.listar());
    }

    @Operation(summary = "Listar ejercicios de una rutina especifica")
    @GetMapping("/rutina/{idRutina}")
    public ResponseEntity<List<EjercicioRutinaDTO>> listarPorRutina(@PathVariable Integer idRutina) {
        return ResponseEntity.ok(ejercicioRutinaService.listarPorRutina(idRutina));
    }

    @Operation(summary = "Eliminar un ejercicio de rutina")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ejercicioRutinaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
