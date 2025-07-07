package com.mycompany.proyectofinal;

// Clase para representar los movimientos de los expedientes
public class Movimiento {

    private String expedienteId;
    private String dependenciaOrigen;
    private String dependenciaDestino;
    private String fechaHora;
    private String observaciones;

    public Movimiento(String expedienteId, String dependenciaOrigen,
            String dependenciaDestino, String fechaHora, String observaciones) {
        this.expedienteId = expedienteId;
        this.dependenciaOrigen = dependenciaOrigen;
        this.dependenciaDestino = dependenciaDestino;
        this.fechaHora = fechaHora;
        this.observaciones = observaciones;
    }

    public String getExpedienteId() {
        return expedienteId;
    }

    public String getDependenciaOrigen() {
        return dependenciaOrigen;
    }

    public String getDependenciaDestino() {
        return dependenciaDestino;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String toString() {
        return "Expediente: " + expedienteId
                + "\nDe: " + dependenciaOrigen
                + "\nA: " + dependenciaDestino
                + "\nFecha/Hora: " + fechaHora
                + "\nObservaciones: " + observaciones;
    }
}
