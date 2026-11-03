package Ejercicio6_UD02;

import Ejercicio6_UD02.Fibonacci;

import java.util.Scanner;

class Ejercicio6_UD02 {
    void main() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Número de Fibonacci a calcular: ");
        int n = keyboard.nextInt();
        Fibonacci[] numbers = new Fibonacci[n + 1];
        Thread[] threads = new Thread[n + 1];
        for (int i = 0; i <= n; i++) {
            numbers[i] = new Fibonacci(i, numbers);
            threads[i] = new Thread(numbers[i]);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                System.out.println("Error en el hilo");
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.printf("Fibonacci %d: %d\n", i, numbers[i].getValue());
        }
        System.out.printf("*************\nFIBONACCI %d: %d\n", n, numbers[n].getValue());
    }
}