package com.example.BiciMap.servicio.TramosHashTable;

import com.example.BiciMap.servicio.RepairPoints.Coordenada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tramoService {
    @Autowired
    private tramo tramoService;
    public void insertar(String clave, List<Coordenada> coordenadas) {
        tramoService.agregarEntrada(clave, coordenadas);
    }
    public List<Coordenada> obtener(String clave) {
        return tramoService.obtenerCoordenadas(clave);
    }
}
