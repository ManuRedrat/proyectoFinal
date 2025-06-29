/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author gonza
 */
// Clase para representar a los interesados en los trámites
// Los estudiantes pueden ver cómo se organizan los datos
public class Interesado {

    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private boolean esTrabajadorULima;

    // Constructor
    public Interesado(String dni, String nombres, String apellidos,
            String telefono, String email, boolean esTrabajadorULima) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.esTrabajadorULima = esTrabajadorULima;
    }

    // Métodos getter (para obtener los valores)
    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public boolean esTrabajadorULima() {
        return esTrabajadorULima;
    }

    // Métodos setter (para cambiar los valores)
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para mostrar la información del interesado
    public String toString() {
        String tipo = esTrabajadorULima ? "Trabajador ULima" : "Externo";
        return "DNI: " + dni
                + "\nNombres: " + nombres + " " + apellidos
                + "\nTeléfono: " + telefono
                + "\nEmail: " + email
                + "\nTipo: " + tipo;
    }
}
