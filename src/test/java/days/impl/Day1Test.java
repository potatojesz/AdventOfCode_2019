package days.impl;

import org.junit.Assert;
import org.junit.Test;

public class Day1Test {
    @Test
    public void testDay1() {
        Assert.assertEquals(2, Day1.calculate(12));
        Assert.assertEquals(2, Day1.calculate(14));
        Assert.assertEquals(654, Day1.calculate(1969));
        Assert.assertEquals(33583, Day1.calculate(100756));
    }

    @Test
    public void testDay1_2() {
        Assert.assertEquals(966, Day1_2.calculate(1969));
        Assert.assertEquals(50346, Day1_2.calculate(100756));
    }
}
