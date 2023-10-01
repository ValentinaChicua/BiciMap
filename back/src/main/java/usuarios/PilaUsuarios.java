package usuarios;
import com.example.BiciMap.modelo.Usuarios;

import java.util.Stack;

public class PilaUsuarios {
    private Stack<Usuarios> pilaUsuarios;

    public PilaUsuarios() {
        pilaUsuarios = new Stack<>();
    }

    public void agregarUsuario(Usuarios usuario) {
        pilaUsuarios.push(usuario);
    }

    public Usuarios leerUsuarioEnCima() {
        if (!pilaUsuarios.isEmpty()) {
            return pilaUsuarios.peek();
        }
        return null; // Pila vacía
    }

    public Usuarios eliminarUsuarioEnCima() {
        if (!pilaUsuarios.isEmpty()) {
            return pilaUsuarios.pop();
        }
        return null; // Pila vacía
    }

    public int obtenerTamañoPila() {
        return pilaUsuarios.size();
    }


    public Usuarios buscarUsuarioPorCorreo(String correoElectronico) {
        for (Usuarios usuario : pilaUsuarios) {
            if (usuario.getCorreoElectronico().equals(correoElectronico)) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }
}

