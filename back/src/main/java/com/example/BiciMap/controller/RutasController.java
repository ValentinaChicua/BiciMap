package com.example.BiciMap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rutas.Queue;
@Controller
@RequestMapping("/rutas")
public class RutasController {
    private final Queue queue = new Queue();
    @PostMapping("/agregar")
    public void agregarRuta(@RequestParam("iniDireccion") String iniDireccion, @RequestParam("finDireccion") String finDireccion) {
        queue.Push(iniDireccion, finDireccion);

    }

    @GetMapping("/mostrar")
    public void mostrarRutas() {
        queue.mostrarRutas();
    }


    @GetMapping("/size")
    public Object obtenerTamanio() {
        return queue.Size();
    }

    @GetMapping("/pop")
    public void sacarRuta() {
        queue.Pop();
    }

    @GetMapping("/head")
    public void mostrarRutaActual() {
        queue.Head();
    }

    @GetMapping("/vacia")
    public boolean estaVacia() {
        return queue.Empty();
    }


}








