package com.example.BiciMap.servicio;

import com.example.BiciMap.modelo.Usuario;
import com.example.BiciMap.modelo.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private ArbolUsuarios.BST arbolUsuarios;

    public void insertarUsuario(Usuario usuario) {
        arbolUsuarios.insertar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return arbolUsuarios.listarUsuarios();
    }

    public Usuario buscarUsuario(String correo) {
        return arbolUsuarios.buscar(correo);
    }

    public void actualizarUsuario(String correo, Usuario nuevoUsuario) {
        arbolUsuarios.actualizar(correo, nuevoUsuario);
    }

    public void eliminarUsuario(String correo) {
        arbolUsuarios.eliminar(correo);
    }
}
