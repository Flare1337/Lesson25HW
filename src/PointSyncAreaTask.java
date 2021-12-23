public class PointSyncAreaTask implements Runnable {
    private final Point point;

    public PointSyncAreaTask(Point point) {
        this.point = point;
    }

    @Override
    public void run() {
        point.moveSyncAreaVersion(point ,1, 1);
    }
}
