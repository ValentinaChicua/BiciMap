package com.example.BiciMap.servicio;

import com.example.BiciMap.modelo.Usuario;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArbolUsuarios {
    public class NodoBST {
        Usuario usuario;
        NodoBST izquierda;
        NodoBST derecha;

        public NodoBST(Usuario usuario) {
            this.usuario = usuario;
            this.izquierda = null;
            this.derecha = null;
        }
    }
    @Component

    public class BST {
        NodoBST raiz;

        public BST() {
            raiz = null;
        }

        public void insertar(Usuario usuario) {
            raiz = insertarRec(raiz, usuario);
            System.out.println("Usuario insertado: " + usuario.getCorreoElectronico());


        }

        private NodoBST insertarRec(NodoBST nodo, Usuario usuario) {
            if (nodo == null) {
                nodo = new NodoBST(usuario);
                return nodo;
            }

            if (usuario.getCorreoElectronico().compareTo(nodo.usuario.getCorreoElectronico()) < 0) {
                nodo.izquierda = insertarRec(nodo.izquierda, usuario);
            } else if (usuario.getCorreoElectronico().compareTo(nodo.usuario.getCorreoElectronico()) > 0) {
                nodo.derecha = insertarRec(nodo.derecha, usuario);
            }

            return nodo;
        }
        public List<Usuario> listarUsuarios() {
            List<Usuario> usuariosList = new ArrayList<>();
            listarUsuariosRec(raiz, usuariosList);
            return usuariosList;
        }

        private void listarUsuariosRec(NodoBST nodo, List<Usuario> usuariosList) {
            if (nodo != null) {
                listarUsuariosRec(nodo.izquierda, usuariosList);
                usuariosList.add(nodo.usuario);
                listarUsuariosRec(nodo.derecha, usuariosList);
            }
        }

        public Usuario buscar(String correo) {
            return buscarRec(raiz, correo);
        }

        private Usuario buscarRec(NodoBST nodo, String correo) {
            if (nodo == null) {
                return null;
            }

            if (correo.equals(nodo.usuario.getCorreoElectronico())) {
                return nodo.usuario;
            }

            if (correo.compareTo(nodo.usuario.getCorreoElectronico()) < 0) {
                return buscarRec(nodo.izquierda, correo);
            }

            return buscarRec(nodo.derecha, correo);
        }

        public void actualizar(String correo, Usuario nuevoUsuario) {
            raiz = actualizarRec(raiz, correo, nuevoUsuario);
        }

        private NodoBST actualizarRec(NodoBST nodo, String correo, Usuario nuevoUsuario) {
            if (nodo == null) {
                return nodo;
            }

            if (correo.equals(nodo.usuario.getCorreoElectronico())) {
                nodo.usuario = nuevoUsuario;
            } else if (correo.compareTo(nodo.usuario.getCorreoElectronico()) < 0) {
                nodo.izquierda = actualizarRec(nodo.izquierda, correo, nuevoUsuario);
            } else {
                nodo.derecha = actualizarRec(nodo.derecha, correo, nuevoUsuario);
            }

            return nodo;
        }

        public void eliminar(String correo) {
            raiz = eliminarRec(raiz, correo);
        }

        private NodoBST eliminarRec(NodoBST nodo, String correo) {
            if (nodo == null) {
                return nodo;
            }

            if (correo.compareTo(nodo.usuario.getCorreoElectronico()) < 0) {
                nodo.izquierda = eliminarRec(nodo.izquierda, correo);
            } else if (correo.compareTo(nodo.usuario.getCorreoElectronico()) > 0) {
                nodo.derecha = eliminarRec(nodo.derecha, correo);
            } else {
                if (nodo.izquierda == null) {
                    return nodo.derecha;
                } else if (nodo.derecha == null) {
                    return nodo.izquierda;
                }

                nodo.usuario = encontrarMinimo(nodo.derecha).usuario;
                nodo.derecha = eliminarRec(nodo.derecha, nodo.usuario.getCorreoElectronico());
            }

            return nodo;
        }

        private NodoBST encontrarMinimo(NodoBST nodo) {
            NodoBST actual = nodo;
            while (actual.izquierda != null) {
                actual = actual.izquierda;
            }
            return actual;
        }
    }

}
