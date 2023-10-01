package com.example.BiciMap.interfaz;

import com.example.BiciMap.modelo.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario  extends CrudRepository<Usuarios,Long> {
}
