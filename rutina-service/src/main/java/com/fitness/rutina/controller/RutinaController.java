package com.fitness.rutina.controller;

import com.fitness.rutina.dto.RutinaDTO;
import com.fitness.rutina.service.RutinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
@RequiredArgsConstructor
@Tag(name = "Rutinas", description = "Gestion de rutinas de entrenamiento")
public class RutinaController {

    private final RutinaService rutinaService;

    @Operation(summary = "Crear una nueva rutina (valida el usuario via usuario-service)")
    @PostMapping
    public ResponseEntity<RutinaDTO> crear(@Valid @RequestBody RutinaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rutinaService.crear(dto));
    }

    @Operation(summary = "Actualizar una rutina")
    @PutMapping("/{id}")
    public ResponseEntity<RutinaDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody RutinaDTO dto) {
        return ResponseEntity.ok(rutinaService.actualizar(id, dto));
    }

    @Operation(summary = "Obtener una rutina por id")
    @GetMapping("/{id}")
    public ResponseEntity<RutinaDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(rutinaService.obtenerPorId(id));
    }

    @Operation(summary = "Listar todas las rutinas")
    @GetMapping
    public ResponseEntity<List<RutinaDTO>> listar() {
        return ResponseEntity.ok(rutinaService.listar());
    }

    @Operation(summary = "Listar rutinas de un usuario")
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<RutinaDTO>> listarPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(rutinaService.listarPorUsuario(idUsuario));
    }

    @Operation(summary = "Eliminar una rutina")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        rutinaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
