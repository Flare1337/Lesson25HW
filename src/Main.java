import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        new Main().showPointWithoutSync();
        new Main().showPointWithMethodSync();
        new Main().showPointSyncArea();
        new Main().showPointStaticAreaSync();
        new Main().showPointStaticSyncMethod();

        FibonacciNumberComputeThreadTask fibonacciThreadTask = new FibonacciNumberComputeThreadTask(5);
        FibonacciNumberComputeRunnableTask fibonacciRunnableTask = new FibonacciNumberComputeRunnableTask(5);

        Thread thread = new Thread(fibonacciRunnableTask);

        fibonacciThreadTask.start();
        thread.start();
    }

    public void showPointSyncArea() {
        Point pointSyncArea = new Point(0 , 0);
        ExecutorService executor = Executors.newCachedThreadPool();
        Collection<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointSyncAreaTask(pointSyncArea));
            results.add(result);
        }

        for (Future<?> result : results) {
            try {
                result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Point with sync area, x and y value: %d & %d%n", pointSyncArea.x, pointSyncArea.y);
    }

    public void showPointStaticSyncMethod() {
        Point pointStaticSyncMethod = new Point(0 , 0);
        ExecutorService executor = Executors.newCachedThreadPool();
        Collection<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointStaticSyncMethodTask(pointStaticSyncMethod));
            results.add(result);
        }

        for (Future<?> result : results) {
            try {
                result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Point static sync method, x and y value: %d & %d%n",
                            pointStaticSyncMethod.x, pointStaticSyncMethod.y);
    }

    public void showPointStaticAreaSync() {
        Point pointStaticAreaSync = new Point(0 , 0);
        ExecutorService executor = Executors.newCachedThreadPool();
        Collection<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointStaticAreaTask(pointStaticAreaSync));
            results.add(result);
        }

        for (Future<?> result : results) {
            try {
                result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Point static sync area, x and y value: %d & %d%n",
                                pointStaticAreaSync.x, pointStaticAreaSync.y);
    }

    public void showPointWithMethodSync() {
        Point pointWithMethodSync = new Point(0 , 0);
        ExecutorService executor = Executors.newCachedThreadPool();
        Collection<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointSyncMethodTask(pointWithMethodSync));
            results.add(result);
        }

        for (Future<?> result : results) {
            try {
                result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Point with sync method, x and y value: %d & %d%n",
                                pointWithMethodSync.x, pointWithMethodSync.y);
    }

    public void showPointWithoutSync() {
        Point point = new Point(0 , 0);
        ExecutorService executor = Executors.newCachedThreadPool();
        Collection<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointMovingTask(point));
            results.add(result);
        }

        for (Future<?> result : results) {
            try {
                result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Point without sync, x and y value: %d & %d%n", point.x, point.y);
    }
}
