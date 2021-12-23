import java.util.concurrent.TimeUnit;

public class FibonacciNumberComputeThreadTask extends Thread {
    public int numberToCalculate;

    public FibonacciNumberComputeThreadTask(int numberToCalculate) {
        this.numberToCalculate = numberToCalculate;
    }

    @Override
    public void run()  {
        int previous = 0;
        int current = 1;
        int newCurrent = 0;
        var counter = 0;
        System.out.println("Beginning of computation fibonacci number (Thread)");
        for (int num = 0; num <= numberToCalculate && !Thread.currentThread().isInterrupted(); num++) {
            System.out.printf("Previous n %d%nPrevious current n %d%nNew fibonacci value: %d (Thread)%n%n",
                                previous, current , (newCurrent = previous + current));
            previous = current;
            current = newCurrent;
            try {
                TimeUnit.SECONDS.sleep(1);
                counter++;
                if (counter == 3) {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                System.out.printf("Interrupted thread task, last fibonacci number %d (Thread)", newCurrent);
            }
        }

        if (Thread.currentThread().isInterrupted()) {
            System.out.println("Whoops, something went wrong! The computing of the fibonacci sequence has been interrupted... (Thread)");
        }

        System.out.println("End of fibonacci number calculation, final result: " + current + " (Thread)");
    }
}