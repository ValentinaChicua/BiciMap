package com.example.BiciMap.repositorio;


import com.example.BiciMap.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    // Define consultas personalizadas si es necesario.
}




