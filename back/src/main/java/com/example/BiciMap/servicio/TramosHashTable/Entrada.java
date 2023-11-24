package com.example.BiciMap.servicio.TramosHashTable;

import com.example.BiciMap.servicio.RepairPoints.Coordenada;

import java.util.List;

public class Entrada {
    private String clave;
    private List<Coordenada> coordenadas;

    public Entrada(String clave, List<Coordenada> coordenadas) {
        this.clave = clave;
        this.coordenadas = coordenadas;
    }

    public String getClave() {
        return clave;
    }

    public List<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }
}