package days.impl;

import org.junit.Assert;
import org.junit.Test;

public class Day1Test {
    @Test
    public void testDay1() {
        Assert.assertTrue(Day1.calculate(12) == 2);
        Assert.assertTrue(Day1.calculate(14) == 2);
        Assert.assertTrue(Day1.calculate(1969) == 654);
        Assert.assertTrue(Day1.calculate(100756) == 33583);
    }
}
