package com.example.BiciMap.controller;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;




@RestController
public class bd {
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/testdb")
    public ResponseEntity<String> testDatabaseConnection() {
        try {
            Query query = entityManager.createNativeQuery("SELECT 1");
            query.getSingleResult();
            return ResponseEntity.ok("La conexión a la base de datos está funcionando correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
