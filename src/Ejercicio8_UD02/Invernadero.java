package Ejercicio8_UD02;

public class Invernadero {
    public static void main(String[] args) {
        int totalMediciones = 12;

        System.out.println("=== Monitorizacion ambiental del invernadero (productor/consumidor) ===");
        System.out.println("Espera activa: el sensor no sobrescribe hasta que el controlador ha leido.");
        System.out.println("Umbral de ventilacion: 28°C | mediciones: " + totalMediciones);

        BufferTemperatura buffer = new BufferTemperatura(totalMediciones);

        SensorTemperatura sensor = new SensorTemperatura(buffer, totalMediciones);
        ControladorAmbiental controlador = new ControladorAmbiental(buffer);


        sensor.start();
        controlador.start();
    }
}