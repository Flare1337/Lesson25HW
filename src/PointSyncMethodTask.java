public class PointSyncMethodTask implements Runnable {
    private final Point point;

    public PointSyncMethodTask(Point point) {
        this.point = point;
    }

    @Override
    public void run() {
        point.moveSyncMethodVersion(point, 1, 1);
    }
}
