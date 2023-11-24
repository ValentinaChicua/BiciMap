package com.example.BiciMap.servicio.CentroDeAyuda;

public class HelpRequest {
    public int priority;
    public String description;
    private String tipoSolicitud;

    public HelpRequest(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }
    public HelpRequest() {
        // Constructor vacío requerido por Jackson para la deserialización
    }
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }
}
