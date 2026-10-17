package Ejercicio4_UD02;

public class Pistas {
    private boolean[] pistasDisponibles = {true, true};


    public synchronized int ocuparPista(String nombreVehiculo) {
        int pistaAsignada = -1;


        while (!hayPistaDisponible()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


        for (int i = 0; i < pistasDisponibles.length; i++) {
            if (pistasDisponibles[i]) {
                pistasDisponibles[i] = false;
                pistaAsignada = i + 1;
                System.out.println(nombreVehiculo + " ha entrado en la pista " + pistaAsignada + ".");
                break;
            }
        }
        return pistaAsignada;
    }


    public synchronized void liberarPista(int numPista, String nombreVehiculo, double tiempoSegundos) {
        pistasDisponibles[numPista - 1] = true;
        System.out.println(nombreVehiculo + " completó la prueba en " + tiempoSegundos + " segundos.");
        System.out.println(nombreVehiculo + " ha salido de la pista " + numPista + ".");


        notifyAll();
    }

    private boolean hayPistaDisponible() {
        for (boolean disponible : pistasDisponibles) {
            if (disponible) return true;
        }
        return false;
    }
}