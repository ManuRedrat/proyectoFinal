package com.mycompany.proyectofinal;

// Clase para representar los movimientos de los expedientes
// Los estudiantes pueden ver cómo se registra el seguimiento
public class Movimiento {

    private String expedienteId;
    private String dependenciaOrigen;
    private String dependenciaDestino;
    private String fechaHora;
    private String observaciones;

    // Constructor
    public Movimiento(String expedienteId, String dependenciaOrigen,
            String dependenciaDestino, String fechaHora, String observaciones) {
        this.expedienteId = expedienteId;
        this.dependenciaOrigen = dependenciaOrigen;
        this.dependenciaDestino = dependenciaDestino;
        this.fechaHora = fechaHora;
        this.observaciones = observaciones;
    }

    // Métodos getter
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

    // Método para mostrar la información del movimiento
    public String toString() {
        return "Expediente: " + expedienteId
                + "\nDe: " + dependenciaOrigen
                + "\nA: " + dependenciaDestino
                + "\nFecha/Hora: " + fechaHora
                + "\nObservaciones: " + observaciones;
    }
}
