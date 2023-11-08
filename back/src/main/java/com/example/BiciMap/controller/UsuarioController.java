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

    private String correoGlobal;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "lista_usuarios"; // Asumiendo que tienes una vista llamada "lista_usuarios"
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

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Usuarios usuario = new Usuarios();
        model.addAttribute("usuario", usuario);
        return "registro_usuario"; // Asumiendo que tienes una vista llamada "registro_usuario"
    }
    @GetMapping("/mapa")
    public String prueba(Model model){
        return  "mapaCiclovia";
    }
    @GetMapping("/ruta")
    public String prueba1(Model model){
        return  "RutaFront";
    }


    @GetMapping("/login")
    public String login(Model model) {
        UsuarioCredenciales usuarioC = new UsuarioCredenciales();
        model.addAttribute("usuarioC", usuarioC);

        return "login";
    }



    @GetMapping("/perfil")
    public String perfilUsuario(Model model) {
        System.out.println(correoGlobal +" si existe");
        Usuario usuario = usuarioService.buscarUsuario(correoGlobal);

        // Establece los valores del usuario en el modelo
        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("apellido", usuario.getApellido());
        model.addAttribute("correoElectronico", usuario.getCorreoElectronico());
        model.addAttribute("ubicacionActual", usuario.getUbicacionActual());
        model.addAttribute("localidad", usuario.getLocalidad());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        return "perfilUsuario";
    }




    @PostMapping("/verificarLogin")
    public String login1(@RequestParam("correoElectronico") String correo, @RequestParam("contraseña") String contrasena) {
        System.out.println(correo);
        correoGlobal=correo;



        if (usuarioService.verificarCredenciales(correo, contrasena)) {
            return "redirect:/usuarios/perfil";
        } else {
            return "redirect:/usuarios/registro";
        }
    }

}
