import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FibonacciNumberComputeRunnableTask implements Runnable {
    public int numberToCalculate;

    public FibonacciNumberComputeRunnableTask(int numberToCalculate) {
        this.numberToCalculate = numberToCalculate;
    }

    @Override
    public void run()  {
        int previous = 0;
        int current = 1;
        int newCurrent = 0;
        var counter = 0;
        System.out.println("Beginning of computation fibonacci number (Runnable)");
        for (int num = 0; num <= numberToCalculate && !Thread.currentThread().isInterrupted(); num++) {
            System.out.printf("Previous n %d%nPrevious current n %d%nNew fibonacci value: %d (Runnable)%n%n",
                                previous, current , (newCurrent = previous + current));
            previous = current;
            current = newCurrent;
            try {
                Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(1);
                counter++;
                if (counter == 3) {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                System.out.printf("Interrupted thread task, last fibonacci number %d (Runnable)", newCurrent);
            }
        }

        if (Thread.currentThread().isInterrupted()) {
            System.out.println("Whoops, something went wrong! The computing of the fibonacci sequence has been interrupted... (Runnable)");
        }

        System.out.println("End of fibonacci number calculation, final result: " + current + " (Runnable)");
    }
}