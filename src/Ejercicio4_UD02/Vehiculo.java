package Ejercicio4_UD02;

public class Vehiculo {
    private String nombre;
    private Pistas bancoPistas;

    public Vehiculo(String nombre, Pistas bancoPistas) {
        this.nombre = nombre;
        this.bancoPistas = bancoPistas;
    }
    @Override
    public void run(){
        int pistaElegida = bancoPistas.ocuparPista(nombre);

        long inicio = System.currentTimeMillis();
        try{
            int tiempoPrueba = (int)(Math.random() * 5000) + 1000;
            Thread.sleep(tiempoPrueba);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long fin = System.currentTimeMillis();
        double tiempoSegundos = (fin - inicio) / 1000;

        bancoPistas.liberarPista(pistaElegida, nombre, tiempoSegundos);
    }
}
