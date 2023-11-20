package com.example.BiciMap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mapeoController {

   private final GraphHopperService graphHopperService;

   @Autowired
    public mapeoController(GraphHopperService graphHopperService) {
        this.graphHopperService = graphHopperService;
    }

    @GetMapping("/calcular-ruta")
    public String calcularRuta(@RequestParam double inicioLat, @RequestParam double inicioLon,
                               @RequestParam double finLat, @RequestParam double finLon) {
        return graphHopperService.obtenerRuta(inicioLat, inicioLon, finLat, finLon);

        // Ejemplo:
        // return graphHopperService.obtenerRuta(4.60971, -74.08175, 4.64828, -74.24789);
    }
}



