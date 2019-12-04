import java.util.List;

public final class FuelCalculator {
    private FuelCalculator() {};

    public static int calculate(int mass) {
        return mass / 3 - 2;
    }
}
