package com.example.BiciMap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class tramoController {
    @GetMapping("/usuarios/tramos")
    public String redirigiraTramo() {
        return "tramos";
    }
}
