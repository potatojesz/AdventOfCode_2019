import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class WireUtils {

    public static final char R = 'R';
    public static final char L = 'L';
    public static final char U = 'U';
    public static final char D = 'D';

    private WireUtils() {
    }

    public static int distance(List<String> input) {
        int result = Integer.MAX_VALUE;
        final List<Point> intersections = getIntersections(input);
        for(Point point : intersections) {
            int newDist = manhatan(point.getX(), point.getY());
            result = newDist < result ? newDist : result;
        }
        return result;
    }

    private static int manhatan(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    private static List<Point> getIntersections(List<String> input) {
        final List<Point> intersections = new ArrayList<>();
        final Set<Point> wirePoints = new LinkedHashSet<>();

        boolean firstWire = true;
        for(String wire : input) {
            String[] wirePointsArr = wire.split(",");
            Point actual = new Point(0, 0);
            for(int i = 0; i < wirePointsArr.length; i++) {
                char dir = wirePointsArr[i].charAt(0);
                int count = Integer.parseInt(wirePointsArr[i].substring(1));
                switch(dir) {
                    case R:
                        int newXR = getNewX(intersections, wirePoints, actual, count, R, firstWire);
                        actual = new Point(newXR, actual.getY());
                        break;
                    case L:
                        int newXL = getNewX(intersections, wirePoints, actual, count, L, firstWire);
                        actual = new Point(newXL, actual.getY());
                        break;
                    case U:
                        int newYU = getNewY(intersections, wirePoints, actual, count, U, firstWire);
                        actual = new Point(actual.getX(), newYU);
                        break;
                    case D:
                        int newYD = getNewY(intersections, wirePoints, actual, count, D, firstWire);
                        actual = new Point(actual.getX(), newYD);
                        break;
                    default:
                        throw new RuntimeException("Unreckognized option!");
                }
            }
            firstWire = false;
        }

        return intersections;
    }

    private static int getNewY(List<Point> intersections, Set<Point> wirePoints, Point actual, int count, char dir, boolean firstWire) {
        boolean first = true;
        int newY = actual.getY() + (dir == U ? count : -count);
        if(dir == U) {
            for(int y = actual.getY(); y < newY + 1; y++) {
                isIntersection(intersections, wirePoints, actual.getX(), y, first);
                if(first && !firstWire) {
                    first = false;
                }
            }
        } else {
            for(int y = actual.getY(); y > newY - 1; y--) {
                isIntersection(intersections, wirePoints, actual.getX(), y, first);
                if(first && !firstWire) {
                    first = false;
                }
            }
        }
        return newY;
    }

    private static int getNewX(List<Point> intersections, Set<Point> wirePoints, Point actual, int count, char dir, boolean firstWire) {
        boolean first = true;
        int newX = actual.getX() + (dir == R ? count : -count);
        if(dir == R) {
            for(int x = actual.getX(); x < newX + 1; x++) {
                isIntersection(intersections, wirePoints, x, actual.getY(), first);
                if(first && !firstWire) {
                    first = false;
                }
            }
        } else {
            for(int x = actual.getX(); x > newX - 1; x--) {
                isIntersection(intersections, wirePoints, x, actual.getY(), first);
                if(first && !firstWire) {
                    first = false;
                }
            }
        }
        return newX;
    }

    private static void isIntersection(List<Point> intersections, Set<Point> wirePoints, int x, int y, boolean first) {
        Point point = new Point(x, y);
        if(wirePoints.contains(point) && !first) {
            intersections.add(point);
        } else {
            wirePoints.add(point);
        }
    }
}
