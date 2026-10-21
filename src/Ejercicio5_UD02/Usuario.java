package Ejercicio5_UD02;

public class Usuario implements Runnable {
    private String nombre;
    private int pisoOrigen;
    private int  pisoDestino;
    private Ascensor ascensor;
    public boolean subido= false;
    public boolean bajado = false;

    public Usuario(String nombre, int pisoOrigen, int pisoDestino) {
        this.nombre = nombre;
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
        this.ascensor = ascensor;
    }

    public  String getnombre() {return nombre;}
    public int getPisoOrigen() {return pisoOrigen;}
    public int getPisoDestino(){return pisoDestino;}

    @Override
    public void run(){
    try {
        System.out.println("Usuario"+ nombre+ "espera en piso"+ pisoOrigen);
        ascensor.agregarUsuario(this);

        synchronized (this){
            while (!subido){
                wait();
            }
        }
            synchronized (this){
            while (!bajado){
                wait();
            }
            }

    }catch (InterruptedException e){
        Thread.currentThread().interrupt();
    }


    }


}
