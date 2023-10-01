package com.example.BiciMap.controller;

import org.springframework.web.bind.annotation.*;
import rutasFrecuentes.frequentDynamicArray;

@RestController
@RequestMapping("/rutas-frecuentes")
public class RutasFrecuentesController {
    private final frequentDynamicArray frequentArray = new frequentDynamicArray();

    @GetMapping("/mostrar")
    public String mostrarRutasFrecuentes() {
        return frequentArray.toString();
    }

    @PostMapping("/agregar")
    public void agregarRutaFrecuente(@RequestParam("ruta") Object ruta) {
        frequentArray.addFrequent(ruta);
    }

    @DeleteMapping("/eliminar")
    public void eliminarRutaFrecuente(@RequestParam("ruta") Object ruta) {
        frequentArray.deleteFrequent(ruta);
    }

    @GetMapping("/buscar")
    public int buscarRutaFrecuente(@RequestParam("ruta") Object ruta) {
        return frequentArray.searchFrequent(ruta);
    }

    @GetMapping("/vacia")
    public boolean estaVacia() {
        return frequentArray.isEmptyFrequent();
    }

    @GetMapping("/size")
    public int obtenerTamanio() {
        return frequentArray.size;
    }
}
