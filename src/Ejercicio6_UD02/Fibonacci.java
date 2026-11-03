package Ejercicio6_UD02;

import java.math.BigInteger;

public class Fibonacci implements Runnable {
    private final int i;
    private final Fibonacci[] numbers;
    private volatile BigInteger value;
    private volatile boolean done = false;


    public Fibonacci(int i, Fibonacci[] numbers) {
        this.i = i;
        this.numbers = numbers;
    }

    public BigInteger getValue() {
        return this.value;
    }

    public boolean isntDone() {
        return !this.done;
    }

    @Override
    public void run() {
        if (this.i == 0) {
            this.value = BigInteger.ZERO;
            this.done = true;
        } else if (this.i == 1) {
            this.value = BigInteger.ONE;
            this.done = true;
        } else {
            Fibonacci iMinusOne = this.numbers[this.i - 1];
            Fibonacci iMinusTwo = this.numbers[this.i - 2];
            while (iMinusOne.isntDone() || iMinusTwo.isntDone()) {}
            this.value = iMinusOne.getValue().add(iMinusTwo.getValue());
            this.done = true;
        }
    }
}

