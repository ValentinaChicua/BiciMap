package com.example.BiciMap.controller;

import com.example.BiciMap.servicio.RepairPoints.Coordenada;
import com.example.BiciMap.servicio.RepairPoints.reparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class reparacionController {
    @Autowired
    reparacionService kdTreeService;

    @PostMapping("/puntosReparacion")
    public ResponseEntity<String> insertarCoordenadas(@RequestBody List<Coordenada> coordenadasList) {
        for (Coordenada coordenada : coordenadasList) {
            kdTreeService.insertar(coordenada);
        }
        return ResponseEntity.ok("Coordenadas insertadas exitosamente");
    }
    @PostMapping("/obtenerPuntosCercanos")
    @ResponseBody
    public ResponseEntity<List<double[]>> obtenerPuntosCercanos(@RequestBody Coordenada coordenadasUsuario) {
        try {
            // Validar las coordenadas de usuario antes de buscar puntos cercanos si es necesario
            double latitud = coordenadasUsuario.getLatitud();
            double longitud = coordenadasUsuario.getLongitud();
            double radio = 5.0; // Definir el radio en kilómetros

            List<double[]> puntosCercanos = kdTreeService.puntosCercanos(latitud, longitud, radio);
            return ResponseEntity.ok(puntosCercanos);
        } catch (Exception e) {
            // Manejar excepciones y devolver una respuesta adecuada
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
