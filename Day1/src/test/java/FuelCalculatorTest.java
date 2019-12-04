import org.junit.Assert;
import org.junit.Test;

public class FuelCalculatorTest {
    @Test
    public void testFuelCalculator() {
        Assert.assertTrue(FuelCalculator.calculate(12) == 2);
        Assert.assertTrue(FuelCalculator.calculate(14) == 2);
        Assert.assertTrue(FuelCalculator.calculate(1969) == 654);
        Assert.assertTrue(FuelCalculator.calculate(100756) == 33583);
    }
}
