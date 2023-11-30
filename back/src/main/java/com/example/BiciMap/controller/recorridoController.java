package com.example.BiciMap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class recorridoController {

    @GetMapping("/usuarios/ruta/iniciarRecorrido")
    public String iniciarRecorrido() {
        return "rutasAvance";
    }
}