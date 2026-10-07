package ejercicio1;

public class main {
    static void main(String[] args) {
        int veces = 100;


        Caracter tarea1 = new Caracter('a', veces);
        Caracter tarea2 = new Caracter('b', veces);
        Caracter tarea3 = new Caracter('c', veces);

        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);
        Thread hilo3 = new Thread(tarea3);

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}


