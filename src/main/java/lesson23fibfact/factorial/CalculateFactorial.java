package lesson23fibfact.factorial;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class CalculateFactorial implements Callable<BigInteger> {

    private BigInteger counter = BigInteger.valueOf(0);
    private BigInteger sum = BigInteger.valueOf(1);

    @Override
    public BigInteger call() {
        while (!Thread.currentThread().isInterrupted()) {
            counter = counter.add(BigInteger.ONE);
            sum = sum.multiply(counter);
            System.out.println("Factorial: " + sum);
        }
        return sum;
    }
}
