package com.fitness.progreso.controller;

import com.fitness.progreso.dto.ProgresoDTO;
import com.fitness.progreso.service.ProgresoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progresos")
@RequiredArgsConstructor
@Tag(name = "Progreso", description = "Registro del progreso fisico del usuario (peso, fechas)")
public class ProgresoController {

    private final ProgresoService progresoService;

    @Operation(summary = "Registrar un nuevo progreso (valida el usuario via usuario-service)")
    @PostMapping
    public ResponseEntity<ProgresoDTO> crear(@Valid @RequestBody ProgresoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(progresoService.crear(dto));
    }

    @Operation(summary = "Actualizar un registro de progreso")
    @PutMapping("/{id}")
    public ResponseEntity<ProgresoDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody ProgresoDTO dto) {
        return ResponseEntity.ok(progresoService.actualizar(id, dto));
    }

    @Operation(summary = "Obtener un registro de progreso por id")
    @GetMapping("/{id}")
    public ResponseEntity<ProgresoDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(progresoService.obtenerPorId(id));
    }

    @Operation(summary = "Listar todos los registros de progreso")
    @GetMapping
    public ResponseEntity<List<ProgresoDTO>> listar() {
        return ResponseEntity.ok(progresoService.listar());
    }

    @Operation(summary = "Listar el historico de progreso de un usuario")
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ProgresoDTO>> listarPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(progresoService.listarPorUsuario(idUsuario));
    }

    @Operation(summary = "Eliminar un registro de progreso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        progresoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
