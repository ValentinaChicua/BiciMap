package com.example.BiciMap.controller;


import com.example.BiciMap.modelo.Usuarios;
import com.example.BiciMap.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String mostrarFormularioUsuario() {
        return "usuario";
    }
    @GetMapping("/listar")
    public String listar(Model model){
        List<Usuarios> usuarios=usuarioService.listar();
        model.addAttribute("usuarios",usuarios);
        return "usuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Model model){

        Usuarios usuario =new Usuarios();
        usuarioService.save(usuario);
        //List<Usuarios> usuarios=usuarioService.listar();
        model.addAttribute("usuarios",usuario);
        return "registro";
    }
}


