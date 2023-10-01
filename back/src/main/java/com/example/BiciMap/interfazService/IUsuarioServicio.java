package com.example.BiciMap.interfazService;

import com.example.BiciMap.modelo.Usuarios;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio {
    public List<Usuarios>listar();
    public Optional<Usuarios> listarId(int id);
    public  int save(Usuarios p);
    public void delete(int id);
}
