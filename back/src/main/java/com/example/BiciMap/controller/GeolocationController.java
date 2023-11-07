package com.example.BiciMap.controller;


import com.example.BiciMap.servicio.RepairPoints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/geolocation")
public class GeolocationController {
    private kdtree arbol; // Asegúrate de que estás usando la correcta clase KdTree.

    @Autowired
    public GeolocationController(kdtree nuevo) {
        arbol = nuevo;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLocation(@RequestBody Coordenada coordenada) {
        double[] coordenadaArray = {coordenada.getLatitud(), coordenada.getLongitud()};
        arbol.insert(coordenadaArray);
        System.out.println("Si se gaurdo");

        return ResponseEntity.ok("Ubicación agregada con éxito.");
    }
    @GetMapping("/getTree")
    public kdtree getArbolKD() {
        return arbol;
    }
}