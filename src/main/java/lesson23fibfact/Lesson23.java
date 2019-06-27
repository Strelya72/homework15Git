package lesson23fibfact;

import lesson23fibfact.factorial.CalculateFactorial;
import lesson23fibfact.fibonacci.CalculatePrintFibonacci;
import lesson23fibfact.stopwatch.StopWatch;

import java.math.BigInteger;
import java.util.concurrent.*;

public class Lesson23 {
    public static void main(String[] args) {

//        // Task 1
//        CalculateFactorial task1 = new CalculateFactorial();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        final Future<BigInteger> result = executor.submit(task1);
//        executor.shutdown();
//        try {
//            result.get(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            System.out.println("Current thread was interrupted/cancelled");
//            result.cancel(true);
//            System.out.println("Factorial has been cancelled");
//        } catch (ExecutionException e) {
//            System.err.println("Internal lesson23fibfact.factorial exception: " + e.getMessage());
//        } catch (TimeoutException e) {
//            result.cancel(true);
//            System.out.println("Factorial has timed out and cancelled");
//        }
//
//        // Task 2
//        CalculatePrintFibonacci task2 = new CalculatePrintFibonacci();
//        ExecutorService executor2 = Executors.newSingleThreadExecutor();
//        final Future<?> result2 = executor2.submit(task2);
//        executor2.shutdown();
//        try {
//            result2.get(50, TimeUnit.MICROSECONDS);
//        } catch (InterruptedException e) {
//            System.out.println("Current thread was interrupted/cancelled");
//            result2.cancel(true);
//            System.out.println("Fibonacci has been cancelled");
//        } catch (ExecutionException e) {
//            System.err.println("Internal fibonacci exception: " + e.getMessage());
//        } catch (TimeoutException e) {
//            result2.cancel(true);
//            System.out.println("Fibonacci has timed out and cancelled");
//        }

        // Task 3
        StopWatch task3 = new StopWatch();
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        final Future<?> result3 = executor3.submit(task3);
        executor3.shutdown();

        try {
            result3.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Current thread was interrupted/cancelled");
            result3.cancel(true);
            executor3.shutdownNow();
            System.out.println("StopWatch has been cancelled");
        } catch (ExecutionException e) {
            System.err.println("Internal stopwatch exception: " + e.getMessage());
        } catch (TimeoutException e) {
            result3.cancel(true);
            executor3.shutdownNow();
            System.out.println("StopWatch has timed out and cancelled");
        }

    }
}
