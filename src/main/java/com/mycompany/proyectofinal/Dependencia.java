package com.mycompany.proyectofinal;

// Clase para representar las dependencias de la universidad
// Los estudiantes pueden ver cómo se organizan los datos
public class Dependencia {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String responsable;

    // Constructor
    public Dependencia(String codigo, String nombre, String descripcion, String responsable) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
    }

    // Métodos getter
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

    // Métodos setter
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    // Método para mostrar la información de la dependencia
    public String toString() {
        return "Código: " + codigo
                + "\nNombre: " + nombre
                + "\nDescripción: " + descripcion
                + "\nResponsable: " + responsable;
    }

    // Método para comparar dependencias por código
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
