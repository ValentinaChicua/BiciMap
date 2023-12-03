package com.example.BiciMap.controller;

//import ch.qos.logback.core.model.Model;
import com.example.BiciMap.servicio.ColaRutas.ColaService;
import com.example.BiciMap.servicio.ColaRutas.QueueActual2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;
import java.util.List;


@Controller
@RequestMapping("/rutas")
public class RutasController {
    private final QueueActual2 queue = new QueueActual2();

    @Autowired
    private ColaService colaService;
    @PostMapping("/agregar")
    public String agregarRuta(@RequestParam("iniDireccion") String iniDireccion, @RequestParam("finDireccion") String finDireccion, Model model) throws Exception {
        queue.Push(iniDireccion, finDireccion);
        model.addAttribute("mensaje", "Ruta agregada correctamente"); // Mensaje para mostrar en la vista
        return "redirect:/rutas/rutasAvance";// Nombre de la plantilla para mostrar después de agregar la ruta
    }
    @GetMapping("/mostrarRutas")
    public String mostrarRutas(Model model) {
        // Obtener las rutas desde la cola
        //QueueActual2 queue = new QueueActual2(); // Instanciar la cola (o puedes inyectarla si es un bean manejado por Spring)
        List<String> rutas = queue.mostrarRutas(); // Método ficticio, deberías implementar uno en tu clase QueueActual2 para obtener las rutas
        model.addAttribute("rutas", rutas); // Agregar las rutas al modelo para mostrar en la plantilla
        return "mostrarRutas"; // Retornar el nombre de la plantilla mostrarRutas.html
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








