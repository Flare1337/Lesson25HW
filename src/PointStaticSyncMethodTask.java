public class PointStaticSyncMethodTask implements Runnable {
    private final Point point;

    public PointStaticSyncMethodTask(Point point) {
        this.point = point;
    }

    @Override
    public void run() {
        Point.moveStaticSyncMethodVersion(point ,1, 1);
    }
}
