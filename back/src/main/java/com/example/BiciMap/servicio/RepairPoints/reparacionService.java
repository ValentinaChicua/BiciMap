package com.example.BiciMap.servicio.RepairPoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reparacionService {
    @Autowired
    private kdtree arbolReparacion;
    public void insertar(Coordenada coordenada) {
        arbolReparacion.insertarRutaDesdeCoordenada(coordenada);
    }
    public List<double[]> puntosCercanos(double latitud, double longitud, double radio) {
        return arbolReparacion.obtenerPuntosCercanos(latitud, longitud, radio);
    }
}
