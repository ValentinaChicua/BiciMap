package com.example.BiciMap.servicio.CentroDeAyuda;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeapService {
    @Autowired
    private MinHeap ColaPrioritaria;
    public void InsertarQueja(HelpRequest value){
        ColaPrioritaria.insert(value);
    }
    public void EnviarCorreo1 (HelpRequest solicitud, String destinatario){
        ColaPrioritaria.enviarCorreo(solicitud,destinatario);
    }

}