package com.fitness.membresia.controller;

import com.fitness.membresia.dto.MembresiaDTO;
import com.fitness.membresia.service.MembresiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
@RequiredArgsConstructor
@Tag(name = "Membresias", description = "Gestion de membresias de usuarios")
public class MembresiaController {

    private final MembresiaService membresiaService;

    @Operation(summary = "Crear una nueva membresia")
    @PostMapping
    public ResponseEntity<MembresiaDTO> crear(@Valid @RequestBody MembresiaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(membresiaService.crear(dto));
    }

    @Operation(summary = "Actualizar una membresia")
    @PutMapping("/{id}")
    public ResponseEntity<MembresiaDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody MembresiaDTO dto) {
        return ResponseEntity.ok(membresiaService.actualizar(id, dto));
    }

    @Operation(summary = "Obtener una membresia por id")
    @GetMapping("/{id}")
    public ResponseEntity<MembresiaDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(membresiaService.obtenerPorId(id));
    }

    @Operation(summary = "Listar todas las membresias")
    @GetMapping
    public ResponseEntity<List<MembresiaDTO>> listar() {
        return ResponseEntity.ok(membresiaService.listar());
    }

    @Operation(summary = "Listar membresias de un usuario")
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<MembresiaDTO>> listarPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(membresiaService.listarPorUsuario(idUsuario));
    }

    @Operation(summary = "Eliminar una membresia")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        membresiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
