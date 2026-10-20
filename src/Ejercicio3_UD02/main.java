package Ejercicio3_UD02;

public class main {
    public static void main(String[] args) throws InterruptedException {
        VariableCompartida vc = new VariableCompartida();
        HebraGet h1 = new HebraGet(vc);
        HebraSet h2 = new HebraSet(vc);
        Thread t1 = new Thread((Runnable) h1);
        Thread t2 = new Thread(h2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Han finalizado");
    }
}
