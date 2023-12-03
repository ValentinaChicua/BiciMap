package com.example.BiciMap.controller;

import historial.Ruta;
import historial.historyDynamicStack;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HistorialController {


    private historyDynamicStack<Ruta> historialRutas = new historyDynamicStack<>();

    @PostMapping("/agregarRutaHistorial")
    public String agregarRuta(@RequestBody Ruta ruta) {
        historialRutas.pushHistory(ruta);
        return "mapaCiclovia";
    }

    @GetMapping("/obtenerHistorialRutas")
    public ResponseEntity<List<Ruta>> obtenerHistorialRutas(Model model) {
        List<Ruta> historial = historialRutas.getHistory();
        model.addAttribute("listaRutas", historial);
        return new ResponseEntity<>(historial, HttpStatus.OK);
    }

    @PostMapping("/limpiarHistorialRutas")
    public String limpiarHistorialRutas() {
        historialRutas.clearHistory();
        return "mapaCiclovia";
    }

    @PostMapping("/elegirRuta")
    public String elegirRuta(@ModelAttribute("ruta") Ruta ruta, Model model) {
        Ruta resultadoBusqueda = historialRutas.searchHistory(ruta);

        model.addAttribute("listaRutas", historialRutas.getHistory());

        if (resultadoBusqueda != null) {
            model.addAttribute("resultadoBusqueda", resultadoBusqueda);
        } else {
            model.addAttribute("rutaNoEncontrada", true);
        }
        return "mapaCiclovia";
    }
}
