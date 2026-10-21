import Ejercicio5_UD02.Ascensor;
import Ejercicio5_UD02.Usuario;

public void main(String[] args)throws InterruptedException {
    Ascensor ascensor = new Ascensor();
    Thread hiloAscensor = new Thread(ascensor);
    hiloAscensor.start();

    Thread u1 = new Thread(new Usuario( "Eustaqio",2,5));
    Thread u2 = new Thread(new Usuario("Paquito",1,3 ));

    u1.start();
    Thread.sleep(1000);
    u2.start();

    u1.join();
    u2.join();

    hiloAscensor.join();
}
