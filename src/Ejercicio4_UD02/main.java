package Ejercicio4_UD02;

public class main {
    public static void main(String[] args) {
        Pistas bancoPista = new Pistas();

        Thread v1=new Thread((Runnable) new Vehiculo("Vehiculo 1", bancoPista));
        Thread v2=new Thread((Runnable) new Vehiculo("Vehiculo 2", bancoPista));
        Thread v3 =new Thread((Runnable) new Vehiculo("Vehiculo 3", bancoPista));
        Thread v4=new Thread((Runnable) new Vehiculo("Vehiculo 4", bancoPista));

        v1.start();
        v2.start();
        v3.start();
        v4.start();
    }
}
