package com.fitness.membresia.client;

import com.fitness.membresia.dto.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioResponse obtenerUsuario(@PathVariable("id") Integer id);

    @GetMapping("/api/usuarios/{id}/existe")
    Boolean existeUsuario(@PathVariable("id") Integer id);
}
