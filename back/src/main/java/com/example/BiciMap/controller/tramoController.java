package com.example.BiciMap.controller;

import com.example.BiciMap.servicio.RepairPoints.Coordenada;

import com.example.BiciMap.servicio.TramosHashTable.tramoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class tramoController {
    @Autowired
    tramoService tramo;
    private final ObjectMapper objectMapper;
    public tramoController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @GetMapping("/usuarios/tramos")
    public String redirigiraTramo() {
        return "tramos";
    }

    @GetMapping("/obtenerCoordenadasTramo/{nombreTramo}")
    public ResponseEntity<String> obtenerCoordenadasTramo(@PathVariable String nombreTramo) {
        List<Coordenada> coordenadas = tramo.obtener(nombreTramo);

        if (coordenadas != null) {
            try {
                // Convertir la lista de coordenadas a formato JSON
                String jsonCoordenadas = objectMapper.writeValueAsString(coordenadas);
                return ResponseEntity.ok(jsonCoordenadas);
            } catch (Exception e) {
                e.printStackTrace(); // Manejo apropiado de la excepción en un entorno de producción
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usuarios/mapaSur3")
    public String mostrarMapaSur3(@RequestParam(name = "coordenadas") String coordenadas, Model model) {
        model.addAttribute("coordenadas", coordenadas);
        return "mapaSur3";
    }

    @GetMapping("/usuarios/mapaCentro2")
    public String mostrarMapaCentro2(@RequestParam(name = "coordenadas") String coordenadas, Model model) {
        model.addAttribute("coordenadas", coordenadas);
        return "mapaCentro2";
    }
    @GetMapping("/usuarios/mapaCentro4")
    public String mostrarMapaCentro4(@RequestParam(name = "coordenadas") String coordenadas, Model model) {
        model.addAttribute("coordenadas", coordenadas);
        return "mapaCentro4";
    }

    @GetMapping("/usuarios/mapaCentro5")
    public String mostrarMapaCentro5(@RequestParam(name = "coordenadas") String coordenadas, Model model) {
        model.addAttribute("coordenadas", coordenadas);
        return "mapaCentro5";
    }
}
