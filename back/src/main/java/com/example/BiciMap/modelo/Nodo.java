package com.example.BiciMap.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nodos") // Nombre de la tabla en la base de datos (ajusta según tu base de datos)
public class Nodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único de cada nodo (auto-generado)

    private String iniDireccion;
    private String finDireccion;
    private double latitudInicio;
    private double longitudInicio;
    private double latitudFin;
    private double longitudFin;
    private double km;

    // Constructor sin argumentos (necesario para JPA)
    public Nodo() {
    }

    public Nodo(String iniD, String finD, double latInicio, double lonInicio, double latFin, double lonFin, double km) {
        this.iniDireccion = iniD;
        this.finDireccion = finD;
        this.latitudInicio = latInicio;
        this.longitudInicio = lonInicio;
        this.latitudFin = latFin;
        this.longitudFin = lonFin;
        this.km = km;
    }


}

