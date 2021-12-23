public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public synchronized void moveSyncMethodVersion(Point point, int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveSyncAreaVersion(Point point, int x, int y) {
        synchronized (point) {
            point.x += x;
            point.y += y;
        }
    }

    public static void moveStaticAreaVersion(Point point, int x, int y) {
        synchronized (point) {
            point.x += x;
            point.y += y;
        }
    }

    public static synchronized void moveStaticSyncMethodVersion(Point point, int dx, int dy) {
        point.x += dx;
        point.y += dy;
    }
}
