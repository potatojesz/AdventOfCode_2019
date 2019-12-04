import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private Utils() {}

    public static final int manhatan(int startX, int startY, int x, int y) {
        return Math.abs(startX - x) + Math.abs(startY - y);
    }

    public static List<Point> preparePlan(String[] input) {
        final List<Point> result = new ArrayList<>();
        Point actual = new Point(0, 0);
        for(int i = 0; i < input.length; i++) {
            Character lastUDdir;
            Character lastRLdir;
            char dir = input[i].charAt(0);
            int count = Integer.parseInt(input[i].substring(1));
            switch(dir) {
                case 'R':
                    actual.setX(actual.getX() + count);
                    lastRLdir = dir;
                    break;
                case 'L':
                    actual.setX(actual.getX() - count);
                    lastRLdir = dir;
                    break;
                case 'U':
                    actual.setY(actual.getY() + count);
                    lastUDdir = dir;
                    break;
                case 'D':
                    actual.setY(actual.getY() - count);
                    lastUDdir = dir;
                    break;
                default:
                    throw new RuntimeException("Unreckognized option!");
            }
        }

        return result;
    }
}
