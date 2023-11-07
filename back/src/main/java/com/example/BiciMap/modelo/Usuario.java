package com.example.BiciMap.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Usuario {


    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contraseña;
    private String ubicacionActual;
    private String localidad;

    public Usuario(String nombre, String apellido, String correoElectronico, String contraseña, String ubicacionActual, String localidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.ubicacionActual = ubicacionActual;
        this.localidad = localidad;
    }

    public Usuario() {

    }
}
