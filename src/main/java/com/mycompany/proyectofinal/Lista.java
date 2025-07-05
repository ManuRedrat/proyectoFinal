package com.mycompany.proyectofinal;

// Implementación de Lista usando arrays como pide el profesor
public class Lista {

    private static final int MAX_SIZE = 100;
    private Object[] data;
    private int tamanio;

    public Lista() {
        data = new Object[MAX_SIZE];
        tamanio = 0;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public boolean isFull() {
        return tamanio == MAX_SIZE;
    }

    public int getTamanio() {
        return tamanio;
    }

    // Agregar al final de la lista
    public void agregar(Object dato) {
        if (isFull()) {
            System.out.println("Lista llena");
            return;
        }
        data[tamanio] = dato;
        tamanio++;
    }

    // Buscar un elemento por índice
    public Object buscar(int indice) {
        if (indice < 0 || indice >= tamanio) {
            System.out.println("Índice fuera de rango");
            return null;
        }
        return data[indice];
    }

    // Eliminar un elemento por índice
    public boolean eliminar(int indice) {
        if (indice < 0 || indice >= tamanio) {
            System.out.println("Índice fuera de rango");
            return false;
        }

        // Mover elementos hacia la izquierda
        for (int i = indice; i < tamanio - 1; i++) {
            data[i] = data[i + 1];
        }
        tamanio--;
        return true;
    }

    // Mostrar todos los elementos de la lista
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacia");
            return;
        }
        System.out.println("Lista:");
        System.out.println("----------------");
        for (int i = 0; i < tamanio; i++) {
            System.out.print(data[i] + " | ");
        }
        System.out.println("");
    }

    // Buscar un elemento por valor
    public int buscarPorValor(Object valor) {
        for (int i = 0; i < tamanio; i++) {
            if (data[i].equals(valor)) {
                return i;
            }
        }
        return -1; // No encontrado
    }
}
