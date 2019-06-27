package lesson23fibfact.fibonacci;

import java.math.BigInteger;

public class FibonacciTaskState implements Runnable {

    private FibonacciState state = FibonacciState.initial();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
//            System.out.println("Fibonacci: " + state.previous);
            BigInteger sum = state.current.add(state.previous);
            state.previous = state.current;
            state.current = sum;
        }
    }

    public FibonacciState getState() {
        return state;
    }

    public static class FibonacciState {
        public BigInteger current;
        public BigInteger previous;

        public static FibonacciState initial() {
            return new FibonacciState(BigInteger.ZERO, BigInteger.ONE);
        }

        public FibonacciState(BigInteger aCurrent, BigInteger aPrevious) {
            current = aCurrent;
            previous = aPrevious;
        }
    }
}
