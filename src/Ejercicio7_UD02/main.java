package Ejercicio7_UD02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        System.out.println("=== Ordenacion por mezcla concurrente ===");

        Random random = new Random();
        int nElementos = random.nextInt(96) + 5;
        List<Integer> listaOriginal = new ArrayList<>();

        for (int i = 0; i < nElementos; i++) {
            listaOriginal.add(random.nextInt(100) + 1);
        }

        System.out.println("Lista original (" + listaOriginal.size() + " elementos):");
        System.out.println(listaOriginal);


        Nodo raiz = new Nodo(listaOriginal);


        raiz.start();

        try {
            raiz.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Lista ordenada:");
        System.out.println(raiz.lista);
    }
}

