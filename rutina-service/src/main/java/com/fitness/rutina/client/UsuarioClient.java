package com.fitness.rutina.client;

import com.fitness.rutina.dto.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente Feign que comunica rutina-service con usuario-service.
 * El nombre "usuario-service" corresponde al que se registra en Eureka.
 * Esta es la comunicacion minima requerida entre 2 microservicios:
 * antes de crear una rutina se valida que el usuario exista.
 */
@FeignClient(name = "usuario-service")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioResponse obtenerUsuario(@PathVariable("id") Integer id);

    @GetMapping("/api/usuarios/{id}/existe")
    Boolean existeUsuario(@PathVariable("id") Integer id);
}
