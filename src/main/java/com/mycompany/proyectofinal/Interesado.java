package com.mycompany.proyectofinal;

// Clase para representar a los interesados en los trámites
public class Interesado {

    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private boolean esTrabajadorULima;

    public Interesado(String dni, String nombres, String apellidos,
            String telefono, String email, boolean esTrabajadorULima) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.esTrabajadorULima = esTrabajadorULima;
    }

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
