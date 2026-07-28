package com.fitness.nutricion.controller;

import com.fitness.nutricion.dto.NutricionDTO;
import com.fitness.nutricion.service.NutricionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nutriciones")
@RequiredArgsConstructor
@Tag(name = "Nutricion", description = "Gestion de planes de alimentacion y nutricion")
public class NutricionController {

    private final NutricionService nutricionService;

    @Operation(summary = "Crear un nuevo plan de nutricion")
    @PostMapping
    public ResponseEntity<NutricionDTO> crear(@Valid @RequestBody NutricionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nutricionService.crear(dto));
    }

    @Operation(summary = "Actualizar un plan de nutricion")
    @PutMapping("/{id}")
    public ResponseEntity<NutricionDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody NutricionDTO dto) {
        return ResponseEntity.ok(nutricionService.actualizar(id, dto));
    }

    @Operation(summary = "Obtener un plan de nutricion por id")
    @GetMapping("/{id}")
    public ResponseEntity<NutricionDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(nutricionService.obtenerPorId(id));
    }

    @Operation(summary = "Listar todos los planes de nutricion")
    @GetMapping
    public ResponseEntity<List<NutricionDTO>> listar() {
        return ResponseEntity.ok(nutricionService.listar());
    }

    @Operation(summary = "Listar planes de nutricion de un usuario")
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<NutricionDTO>> listarPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(nutricionService.listarPorUsuario(idUsuario));
    }

    @Operation(summary = "Eliminar un plan de nutricion")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        nutricionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
