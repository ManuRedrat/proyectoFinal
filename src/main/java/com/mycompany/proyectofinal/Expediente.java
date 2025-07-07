package com.mycompany.proyectofinal;

// Clase principal para representar los expedientes
public class Expediente {

    private String id;
    private int prioridad; //1 = Alta, 2 = Media, 3 = Baja
    private Interesado interesado;
    private String asunto;
    private String documentoReferencia;
    private String fechaInicio;
    private String fechaFin;
    private String estado; //"Pendiente", "En Proceso", "Finalizado"
    private String dependenciaActual;
    private Pila historialMovimientos;

    public Expediente(String id, int prioridad, Interesado interesado,
            String asunto, String documentoReferencia) {
        this.id = id;
        this.prioridad = prioridad;
        this.interesado = interesado;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
        this.fechaInicio = obtenerFechaHoraActual();
        this.fechaFin = "";
        this.estado = "Pendiente";
        this.dependenciaActual = "Recepción";
        this.historialMovimientos = new Pila();
    }

    private String obtenerFechaHoraActual() {
        java.util.Date fecha = new java.util.Date();
        return fecha.toString();
    }

    public String getId() {
        return id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDocumentoReferencia() {
        return documentoReferencia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public String getDependenciaActual() {
        return dependenciaActual;
    }

    public Pila getHistorialMovimientos() {
        return historialMovimientos;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDependenciaActual(String dependenciaActual) {
        this.dependenciaActual = dependenciaActual;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    //Método para agregar un movimiento al historial
    public void agregarMovimiento(Movimiento movimiento) {
        historialMovimientos.push(movimiento);
    }

    //Método para finalizar el expediente
    public void finalizar() {
        this.estado = "Finalizado";
        this.fechaFin = obtenerFechaHoraActual();
    }

    //Método para mostrar la información del expediente
    public String toString() {
        String prioridadTexto = "";
        switch (prioridad) {
            case 1:
                prioridadTexto = "Alta";
                break;
            case 2:
                prioridadTexto = "Media";
                break;
            case 3:
                prioridadTexto = "Baja";
                break;
        }

        return "ID: " + id
                + "\nPrioridad: " + prioridadTexto
                + "\nAsunto: " + asunto
                + "\nEstado: " + estado
                + "\nDependencia Actual: " + dependenciaActual
                + "\nFecha Inicio: " + fechaInicio
                + "\nFecha Fin: " + (fechaFin.isEmpty() ? "Pendiente" : fechaFin)
                + "\n\nDATOS DEL INTERESADO:\n" + interesado.toString();
    }

    //Método para obtener información resumida
    public String getResumen() {
        String prioridadTexto = "";
        switch (prioridad) {
            case 1:
                prioridadTexto = "Alta";
                break;
            case 2:
                prioridadTexto = "Media";
                break;
            case 3:
                prioridadTexto = "Baja";
                break;
        }

        return "ID: " + id + " | Prioridad: " + prioridadTexto
                + " | Estado: " + estado + " | Asunto: " + asunto;
    }
}
