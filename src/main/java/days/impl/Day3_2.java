package days.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.io.Resources;
import days.Day;
import days.InjectDay;
import models.Point;
import org.apache.commons.lang3.tuple.Pair;

@InjectDay
public class Day3_2 implements Day {
    public static final char R = 'R';
    public static final char L = 'L';
    public static final char U = 'U';
    public static final char D = 'D';

    public static final String FIRST_WIRE = "FIRST";
    public static final String SECOND_WIRE = "SECOND";

    @Override
    public int execute() {
        return steps((Map<String, String>) input());
    }

    @Override
    public Object input() {
        LinkedHashMap<String, String> wires = new LinkedHashMap<String, String>();
        try(InputStream stream = Resources.getResource("input_day3.txt").openStream()) {
            try {
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                    wires.put(FIRST_WIRE, reader.readLine());
                    wires.put(SECOND_WIRE, reader.readLine());
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return wires;
    }

    @Override
    public String toString() {
        String result = "Day3_2 Answer: " + String.valueOf(execute());
        Logger.getGlobal().log(Level.INFO, result);

        return result;
    }

    public static int steps(Map<String, String> input) {
        int result = Integer.MAX_VALUE;
        final Map<Point, Integer> intersections = getIntersections(input);
        for(Point point : intersections.keySet()) {
            int steps = intersections.get(point);
            result = Math.min(steps, result);
        }
        return result;
    }

    private static Map<Point, Integer> getIntersections(Map<String, String> input) {
        final Map<Point, Integer> intersections = new LinkedHashMap<>();
        final Map<Point, Map.Entry<String, Integer>> wirePoints = new LinkedHashMap<>();

        boolean firstWire = true;
        for(String wireKey : input.keySet()) {
            String[] wirePointsArr = input.get(wireKey).split(",");
            Point actual = new Point(0, 0);
            int steps = 0;
            for(int i = 0; i < wirePointsArr.length; i++) {
                char dir = wirePointsArr[i].charAt(0);
                int count = Integer.parseInt(wirePointsArr[i].substring(1));
                switch(dir) {
                    case R:
                        Map.Entry<Integer, Integer> newXR = getNewX(intersections, wirePoints, actual, count, R, firstWire, steps, wireKey);
                        steps = newXR.getValue();
                        actual = new Point(newXR.getKey(), actual.getY());
                        break;
                    case L:
                        Map.Entry<Integer, Integer> newXL = getNewX(intersections, wirePoints, actual, count, L, firstWire, steps, wireKey);
                        steps = newXL.getValue();
                        actual = new Point(newXL.getKey(), actual.getY());
                        break;
                    case U:
                        Map.Entry<Integer, Integer> newYU = getNewY(intersections, wirePoints, actual, count, U, firstWire, steps, wireKey);
                        steps = newYU.getValue();
                        actual = new Point(actual.getX(), newYU.getKey());
                        break;
                    case D:
                        Map.Entry<Integer, Integer> newYD = getNewY(intersections, wirePoints, actual, count, D, firstWire, steps, wireKey);
                        steps = newYD.getValue();
                        actual = new Point(actual.getX(), newYD.getKey());
                        break;
                    default:
                        throw new RuntimeException("Unreckognized option!");
                }
            }
            firstWire = false;
        }

        return intersections;
    }

    private static Map.Entry<Integer, Integer> getNewY(Map<Point, Integer> intersections, Map<Point, Map.Entry<String, Integer>> wirePoints, Point actual, int count, char dir, boolean firstWire, int steps, String wireKey) {
        boolean first = true;
        int newY = actual.getY() + (dir == U ? count : -count);
        int newSteps = steps;
        if(dir == U) {
            for(int y = actual.getY(); y < newY + 1; y++) {
                if(!first) {
                    newSteps++;
                }
                isIntersection(intersections, wirePoints, actual.getX(), y, first || firstWire, newSteps, wireKey);
                if(first) {
                    first = false;
                }
            }
        } else {
            for(int y = actual.getY(); y > newY - 1; y--) {
                if(!first) {
                    newSteps++;
                }
                isIntersection(intersections, wirePoints, actual.getX(), y, first || firstWire, newSteps, wireKey);
                if(first) {
                    first = false;
                }
            }
        }
        return Pair.of(newY, newSteps);
    }

    private static Map.Entry<Integer, Integer> getNewX(Map<Point, Integer> intersections, Map<Point, Map.Entry<String, Integer>> wirePoints, Point actual, int count, char dir, boolean firstWire, int steps, String wireKey) {
        boolean first = true;
        int newX = actual.getX() + (dir == R ? count : -count);
        int newSteps = steps;
        if(dir == R) {
            for(int x = actual.getX(); x < newX + 1; x++) {
                if(!first) {
                    newSteps++;
                }
                isIntersection(intersections, wirePoints, x, actual.getY(), first || firstWire, newSteps, wireKey);
                if(first) {
                    first = false;
                }
            }
        } else {
            for(int x = actual.getX(); x > newX - 1; x--) {
                if(!first) {
                    newSteps++;
                }
                isIntersection(intersections, wirePoints, x, actual.getY(), first || firstWire, newSteps, wireKey);
                if(first) {
                    first = false;
                }
            }
        }
        return Pair.of(newX, newSteps);
    }

    private static void isIntersection(Map<Point, Integer> intersections, Map<Point, Map.Entry<String, Integer>> wirePoints, int x, int y, boolean first, int steps, String wireKey) {
        Point point = new Point(x, y);
        if(wirePoints.containsKey(point) && !first) {
            if(!wirePoints.get(point).getValue().equals(wireKey)) {
                intersections.put(point, wirePoints.get(point).getValue() + steps);
            }
        } else {
            wirePoints.put(point, Pair.of(wireKey, steps));
        }
    }
}
