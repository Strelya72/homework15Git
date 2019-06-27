package lesson23fibfact.fibonacci;

import java.math.BigInteger;

public class CalculatePrintFibonacci implements Runnable {

    private BigInteger previous = BigInteger.valueOf(0);
    private BigInteger current = BigInteger.valueOf(1);

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Fibonacci: " + previous);

            BigInteger sum = current.add(previous);
            previous = current;
            current = sum;
        }
    }
}
