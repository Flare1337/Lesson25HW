public class PointStaticAreaTask implements Runnable {
    private final Point point;

    public PointStaticAreaTask(Point point) {
        this.point = point;
    }

    @Override
    public void run() {
        Point.moveStaticAreaVersion(point ,1, 1);
    }
}
