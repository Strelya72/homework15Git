package lesson23fibfact.stopwatch;

public class StopWatch implements Runnable {
    private int seconds = 0;
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(seconds);
                seconds++;
                Thread.yield();
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
