package ejercicio1;

public class Caracter implements Runnable {
private char caracter;
private int repeticion;

public Caracter(char caracter, int repeticion) {
    this.caracter = caracter;
    this.repeticion = repeticion;
}

    @Override
    public void run() {
for (int i = 0; i < repeticion; i++) {
    System.out.print(caracter);
    }

    }
}

