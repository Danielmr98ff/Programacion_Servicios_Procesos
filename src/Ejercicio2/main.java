package Ejercicio2;

public class main {
    public static void main(String[] args) {
        VariableCompartida vc= new VariableCompartida(0);

        int numInteracciones=10;

        Hilo h1=new Hilo(vc,numInteracciones);
        Hilo h2=new Hilo(vc,numInteracciones);

        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Valor final de la variable compartida: " + vc.getV());


    }
}
