package Ejercicio8_UD02;

class BufferTemperatura {
    private int temperatura;
    private int numeroMedicion;
    private boolean disponible = false;
    private boolean finMediciones = false;
    private final int totalMediciones;

    public BufferTemperatura(int totalMediciones) {
        this.totalMediciones = totalMediciones;
    }


    public synchronized void publicarMedicion(int num, int temp) throws InterruptedException {

        while (disponible && !finMediciones) {
            wait();
        }

        this.numeroMedicion = num;
        this.temperatura = temp;
        this.disponible = true;


        notifyAll();
    }


    public synchronized DatosMedicion leerMedicion() throws InterruptedException {

        while (!disponible && !finMediciones) {
            System.out.println(" esperando medicion...");
            wait();
        }

        if (!disponible && finMediciones) {
            return null;
        }

        disponible = false;
        notifyAll();

        return new DatosMedicion(numeroMedicion, temperatura);
    }

    public synchronized void cerrarBuffer() {
        this.finMediciones = true;
        notifyAll();
    }
}


class DatosMedicion {
    int numero;
    int temperatura;

    public DatosMedicion(int numero, int temperatura) {
        this.numero = numero;
        this.temperatura = temperatura;
    }
}
