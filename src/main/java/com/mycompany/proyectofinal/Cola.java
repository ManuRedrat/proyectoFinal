package com.mycompany.proyectofinal;

//Implementación de Cola usando arrays
public class Cola {

    private static final int MAX_SIZE = 100;
    private Object[] data;
    private int ini;
    private int fin;
    private int cantidad;

    public Cola() {
        data = new Object[MAX_SIZE];
        ini = 0;
        fin = -1;
        cantidad = 0;
    }

    public boolean isEmpty() {
        return cantidad == 0;
    }

    public boolean isFull() {
        return cantidad == MAX_SIZE;
    }

    public void encolar(Object item) {
        if (isFull()) {
            System.out.println("Cola llena.");
            return;
        }
        fin = (fin + 1) % MAX_SIZE;
        data[fin] = item;
        cantidad++;
    }

    public Object desencolar() {
        if (isEmpty()) {
            System.out.println("Cola vacia.");
            return null;
        }
        Object item = data[ini];
        ini = (ini + 1) % MAX_SIZE;
        cantidad--;
        return item;
    }

    public void printCola() {
        if (isEmpty()) {
            System.out.println("Cola vacia");
            return;
        }
        System.out.println("Cola:");
        System.out.println("----------------");
        for (int i = 0; i < cantidad; i++) {
            int ind = (ini + i) % MAX_SIZE;
            System.out.print(data[ind] + " | ");
        }
        System.out.println("");
    }

    //Método  para ver el frente sin borrarlo
    public Object verFrente() {
        if (isEmpty()) {
            System.out.println("Cola vacia");
            return null;
        }
        return data[ini];
    }

    //Método para obtener el tamaño de la cola
    public int getTamanio() {
        return cantidad;
    }
}
