package Ejercicio8_UD02;

import java.util.Random;

class SensorTemperatura extends Thread {
    private final BufferTemperatura buffer;
    private final int totalMediciones;

    public SensorTemperatura(BufferTemperatura buffer, int totalMediciones) {
        this.buffer = buffer;
        this.totalMediciones = totalMediciones;
    }

    @Override
    public void run() {
        Random random = new Random();
        int[] tempsSimuladas = {25, 20, 33, 31, 34, 28, 34, 29, 33, 27, 15, 27};

        try {
            for (int i = 1; i <= totalMediciones; i++) {
                int temp = (i - 1 < tempsSimuladas.length) ? tempsSimuladas[i - 1] : (15 + random.nextInt(20));

                buffer.publicarMedicion(i, temp);
                System.out.printf(" publica medicion %02d: %d°C%n", i, temp);

                Thread.sleep(400);
            }
            buffer.cerrarBuffer();
            System.out.println(" fin de las mediciones, buffer cerrado");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}