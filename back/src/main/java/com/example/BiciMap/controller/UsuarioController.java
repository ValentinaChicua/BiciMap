package com.example.BiciMap.controller;


import com.example.BiciMap.modelo.Usuario;
import com.example.BiciMap.modelo.UsuarioCredenciales;
import com.example.BiciMap.modelo.Usuarios;
import com.example.BiciMap.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "lista_usuarios"; // Asumiendo que tienes una vista llamada "lista_usuarios"
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Usuarios usuario = new Usuarios();
        model.addAttribute("usuario", usuario);
        return "registro_usuario"; // Asumiendo que tienes una vista llamada "registro_usuario"
    }
    @GetMapping("/login")
    public String login(Model model) {
        UsuarioCredenciales usuarioC = new UsuarioCredenciales();
        model.addAttribute("usuarioC", usuarioC);
        return "login";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("correoElectronico") String correoElectronico, @RequestParam("contraseña") String contraseña, @RequestParam("ubicacionActual") String ubicacionActual, @RequestParam("localidad") String localidad) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setContraseña(contraseña);
        usuario.setUbicacionActual(ubicacionActual);
        usuario.setLocalidad(localidad);

        usuarioService.insertarUsuario(usuario);

        return "redirect:/usuarios/listar"; // Redirige a la lista de usuarios después de guardar
    }





    @GetMapping("/editar/{correo}")
    public String mostrarFormularioEdicion(@PathVariable String correo, Model model) {
        Usuario usuario = usuarioService.buscarUsuario(correo);
        model.addAttribute("usuario", usuario);
        return "editar_usuario"; // Asumiendo que tienes una vista llamada "editar_usuario"
    }

    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.actualizarUsuario(usuario.getCorreoElectronico(), usuario);
        return "redirect:/usuarios/listar"; // Redirige a la lista de usuarios después de actualizar
    }

    @GetMapping("/eliminar/{correo}")
    public String eliminarUsuario(@PathVariable String correo) {
        usuarioService.eliminarUsuario(correo);
        return "redirect:/usuarios/listar"; // Redirige a la lista de usuarios después de eliminar
    }

    @PostMapping("/verificarLogin")
    public String login1(@RequestParam("correoElectronico") String correo, @RequestParam("contraseña") String contrasena) {
        System.out.println(correo);

        if (usuarioService.verificarCredenciales(correo, contrasena)) {
            return "perfilUsuario";
        } else {
            return "login";
        }
    }

}
