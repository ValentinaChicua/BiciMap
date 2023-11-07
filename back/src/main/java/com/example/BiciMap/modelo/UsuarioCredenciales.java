package com.example.BiciMap.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class UsuarioCredenciales {
    private String correoElectronico;
    private String contraseña;
}