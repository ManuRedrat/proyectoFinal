package com.mycompany.proyectofinal;

// Clase para representar las dependencias de la universidad
public class Dependencia {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String responsable;

    public Dependencia(String codigo, String nombre, String descripcion, String responsable) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String toString() {
        return "Código: " + codigo
                + "\nNombre: " + nombre
                + "\nDescripción: " + descripcion
                + "\nResponsable: " + responsable;
    }

    //Método para comparar dependencias por código
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dependencia otra = (Dependencia) obj;
        return codigo.equals(otra.codigo);
    }
}
