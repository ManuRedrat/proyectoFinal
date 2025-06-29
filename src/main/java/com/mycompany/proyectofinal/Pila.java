/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author gonza
 */
// Implementación de Pila usando arrays como pide el profesor
public class Pila {

    private static final int MAX_SIZE = 100;
    private Object[] data;
    private int top;

    public Pila() {
        data = new Object[MAX_SIZE];
        top = -1;
    }

    public boolean isEmpty() {
        boolean ans = (top == -1);
        return ans;
    }

    public boolean isFull() {
        boolean ans = (top + 1 == MAX_SIZE);
        return ans;
    }

    public void push(Object item) {
        if (!isFull()) {
            top++;
            data[top] = item;
        } else {
            System.out.println("Pila llena");
        }
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return null;
        }
        Object value = data[top];
        top--;
        return value;
    }

    // Método para mostrar la cima sin alterar la pila
    public Object printCima() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return null;
        }
        return data[top];
    }

    // Método para mostrar todos los elementos de la pila
    public void printPila() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return;
        }
        System.out.println("Pila:");
        System.out.println("----------------");
        for (int i = 0; i <= top; i++) {
            System.out.print(data[i] + " | ");
        }
        System.out.println("");
    }

    // Método para obtener el tamaño de la pila
    public int getTamanio() {
        return top + 1;
    }
}
