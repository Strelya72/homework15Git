package lesson24observer.copyfiles;

import lesson23fibfact.fibonacci.FibonacciTaskState;

import java.util.concurrent.*;

public class Lesson24Fibbonaci {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        FibonacciTaskState task = new FibonacciTaskState();
        Future<?> result = executor.submit(task);
        executor.shutdown();

        try {
            result.get(1, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            result.cancel(true);
        }

        final FibonacciTaskState.FibonacciState state = task.getState();
        System.out.println(String.valueOf(state.current));
    }
}
