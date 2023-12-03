package com.example.BiciMap.servicio.ColaRutas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColaService {
    @Autowired
    private QueueActual2 cola;

    public void Push(String address1, String address2) throws Exception {
        cola.Push(address1, address2);
    }
    public void mostrarRutas(){
         cola.mostrarRutas();
    }
    public List<String> obtenerRutas() {
        List<String> rutasEjecutadas = new ArrayList<>();
        NodoActual2 current = cola.head;
        while (current != null) {
            String ruta = "Inicio: " + current.iniDireccion +
                    ", Fin: " + current.finDireccion +
                    ", Longitud: " + (double) Math.round(current.km * 100d) / 100 + " km";
            rutasEjecutadas.add(ruta);
            current = current.next;
        }
        return rutasEjecutadas;
    }
}
