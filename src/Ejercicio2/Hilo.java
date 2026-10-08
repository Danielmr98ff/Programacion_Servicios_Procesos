package Ejercicio2;

public class Hilo extends Thread{
    private VariableCompartida vc;
    private int interaccion;

    public Hilo(VariableCompartida vc, int interaccion){
        this.vc = vc;
        this.interaccion = interaccion;
    }

    @Override
    public void run() {
        for (int i = 0; i < interaccion; i++) {
            vc.incrementar();
        }
    }
}
