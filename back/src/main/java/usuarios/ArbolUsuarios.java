package usuarios;

import com.example.BiciMap.modelo.Usuarios;
import org.springframework.stereotype.Service;

@Service
public class ArbolUsuarios {
    public class NodoBST {
        Usuarios usuario;
        NodoBST izquierda;
        NodoBST derecha;

        public NodoBST(Usuarios usuario) {
            this.usuario = usuario;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    public class BST {
        NodoBST raiz;

        public BST() {
            raiz = null;
        }

        public void insertar(Usuarios usuario) {
            raiz = insertarRec(raiz, usuario);


        }

        private NodoBST insertarRec(NodoBST nodo, Usuarios usuario) {
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

        public Usuarios buscar(String correo) {
            return buscarRec(raiz, correo);
        }

        private Usuarios buscarRec(NodoBST nodo, String correo) {
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

        public void actualizar(String correo, Usuarios nuevoUsuario) {
            raiz = actualizarRec(raiz, correo, nuevoUsuario);
        }

        private NodoBST actualizarRec(NodoBST nodo, String correo, Usuarios nuevoUsuario) {
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
