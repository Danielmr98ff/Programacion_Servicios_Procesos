package Ejercicio8_UD02;

class ControladorAmbiental extends Thread {
    private final BufferTemperatura buffer;
    private final int UMBRAL = 28;

    public ControladorAmbiental(BufferTemperatura buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                DatosMedicion dato = buffer.leerMedicion();
                if (dato == null) {
                    break;
                }

                if (dato.temperatura > UMBRAL) {
                    System.out.printf("lee medicion %02d: %d°C -> EXCEDE EL UMBRAL de %d°C, VENTILACION ACTIVADA%n",
                            dato.numero, dato.temperatura, UMBRAL);
                } else {
                    System.out.printf(" lee medicion %02d: %d°C -> en rango normal, todo correcto%n",
                            dato.numero, dato.temperatura);
                }

                Thread.sleep(300);
            }
            System.out.println(" fin del monitoreo");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}