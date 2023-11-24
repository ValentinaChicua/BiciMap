package com.example.BiciMap.controller;


import com.example.BiciMap.servicio.CentroDeAyuda.HeapService;
import com.example.BiciMap.servicio.CentroDeAyuda.HelpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HeapController {
    @Autowired
    private HeapService ColaService;

    @GetMapping("/tiposSolicitud")
    public String mostrarTiposSolicitud() {
        return "botonesSolicitudes"; // Nombre de la vista que muestra los tipos de solicitud
    }

    @GetMapping("/SolicitudesBicimaps")
    public String QuejasView (){
        return "cuadroqueja";
    }

    //@PostMapping ("/enviarSolicitud")
    //public String EnviarQueja (HelpRequest solicitud, Model model){
    //    ColaService.InsertarQueja(solicitud);
    //    ColaService.EnviarCorreo1(solicitud, "bicimapsun2023@gmail.com");
    //    model.addAttribute("envioExitoso", true); // Agregar atributo al modelo
    //return "redirect:/SolicitudesBicimaps";
    //    return "redirect:/botonesSolicitudes";
    //}

    @PostMapping("/enviarSolicitud")
    public ResponseEntity<String> EnviarQueja(@RequestBody JsonNode solicitudJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        HelpRequest solicitud;

        try {
            // Mapear el JSON enviado a un objeto HelpRequest
            solicitud = objectMapper.treeToValue(solicitudJson, HelpRequest.class);

            // Procesar la solicitud, asignar prioridad, enviar correo, etc.
            int prioridad = obtenerPrioridadPorTipoSolicitud(solicitud.getTipoSolicitud());
            solicitud.setPriority(prioridad);


            // Insertar en la cola y enviar correo
            ColaService.InsertarQueja(solicitud);
            ColaService.EnviarCorreo1(solicitud, "bicimapsun2023@gmail.com");

            return ResponseEntity.ok("{\"success\": true}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"success\": false}");
        }
    }



    private int obtenerPrioridadPorTipoSolicitud(String tipoSolicitud) {
        int prioridad = 0;

        switch (tipoSolicitud) {
            case "fallas":
                prioridad = 1;
                break;
            case "emergencia":
                prioridad = 2;
                break;
            case "actualizacion":
                prioridad = 3;
                break;
            case "datos":
                prioridad = 4;
                break;
            case "quejas":
                prioridad = 5;
                break;
            case "sugerencias":
                prioridad = 6;
                break;
            default:
                // Asignar una prioridad por defecto o manejar de acuerdo a tu lógica
                break;
        }

        return prioridad;
    }



    @GetMapping("/formulario")
    public String mostrarFormulario(@RequestParam("solicitud") String tipoSolicitud) {
        // Lógica para procesar el tipo de solicitud y enviar al formulario correspondiente
        // Puedes redirigir al formulario adecuado en función del tipo de solicitud recibida
        // Por ejemplo:
        if ("fallas".equals(tipoSolicitud)) {
            return "cuadroqueja"; // Nombre de la vista para la solicitud de fallas
        } else if ("emergencia".equals(tipoSolicitud)) {
            return "cuadroqueja"; // Nombre de la vista para la solicitud de emergencia, etc.
        } else if ("actualizacion".equals(tipoSolicitud)) {
            return "cuadroqueja";
        } else if ("datos".equals(tipoSolicitud)) {
            return "cuadroqueja";
        } else if ("quejas".equals(tipoSolicitud)) {
            return "cuadroqueja";
        } else if ("sugerencias".equals(tipoSolicitud)) {
            return "cuadroqueja";
        }
        // En caso de solicitud desconocida, redirigir a una página de error o a la página principal
        return "paginaDeError";
    }

    @GetMapping("/usuarios/ayuda")
    public String redirigiraCentroAyuda() {
        return "botonesSolicitudes";
    }
}
