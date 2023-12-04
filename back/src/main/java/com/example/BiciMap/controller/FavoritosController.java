package com.example.BiciMap.controller;

import favoritos.favoriteDynamicArray;
import historial.Ruta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FavoritosController {

       private favoriteDynamicArray<Ruta> rutasFavoritas = new favoriteDynamicArray<>();

        @PostMapping("/agregarRutaFavoritos")
        public String agregarRuta(@RequestBody Ruta ruta) {
            rutasFavoritas.addFavorites(ruta);
            return "mapaCiclovia";
        }

        @GetMapping("/obtenerFavoritos")
        public ResponseEntity<List<Ruta>> obtenerFavoritos(Model model) {
            List<Ruta> favoritos = rutasFavoritas.getFavorites();
            model.addAttribute("listaFavoritos", favoritos);
            return new ResponseEntity<>(favoritos, HttpStatus.OK);
        }

        @PostMapping("/borrarFavoritos")
        public String borrarFavoritos() {
            rutasFavoritas.clearFavorites();
            return "mapaCiclovia";
        }
        @PostMapping("/borrarFavorito")
        public String borrarFavorito(@RequestParam String rutainicio, @RequestParam String rutafin) {
        Ruta rutaABorrar = new Ruta(rutainicio, rutafin);
        rutasFavoritas.deleteFavorites(rutaABorrar);
        return "mapaCiclovia";
         }

        }
