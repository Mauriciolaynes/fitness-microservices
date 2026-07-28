package com.fitness.ejercicio.client;

import com.fitness.ejercicio.dto.RutinaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rutina-service")
public interface RutinaClient {

    @GetMapping("/api/rutinas/{id}")
    RutinaResponse obtenerRutina(@PathVariable("id") Integer id);

    @GetMapping("/api/rutinas/{id}/existe")
    Boolean existeRutina(@PathVariable("id") Integer id);
}
