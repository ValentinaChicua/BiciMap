package com.example.BiciMap.servicio.ColaRutas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
