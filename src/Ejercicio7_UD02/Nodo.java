package Ejercicio7_UD02;

import java.util.ArrayList;
import java.util.List;

public class Nodo extends Thread {

    final List<Integer> lista;

    public Nodo(List<Integer> lista) {
        this.lista = lista;
    }


    private void añade(List<Integer> l, int desde, int hasta) {
        for (int i = desde; i < hasta; i++) {
            l.add(this.lista.get(i));
        }
    }

    private void mezcla(List<Integer> l1, List<Integer> l2) {
        this.lista.clear();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                this.lista.add(l1.get(i++));
            } else {
                this.lista.add(l2.get(j++));
            }
        }
        while (i < l1.size()) {
            this.lista.add(l1.get(i++));
        }
        while (j < l2.size()) {
            this.lista.add(l2.get(j++));
        }
    }

    @Override
    public void run() {

        if (lista.size() <= 1) {
            return;
        }

        int mitad = lista.size() / 2;


        List<Integer> izquierda = new ArrayList<>();
        List<Integer> derecha = new ArrayList<>();


        añade(izquierda, 0, mitad);
        añade(derecha, mitad, lista.size());


        Nodo nodoIzquierda = new Nodo(izquierda);
        Nodo nodoDerecha = new Nodo(derecha);


        nodoIzquierda.start();
        nodoDerecha.start();

        try {

            nodoIzquierda.join();
            nodoDerecha.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
}
