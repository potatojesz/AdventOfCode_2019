package days.impl;

import org.junit.Assert;
import org.junit.Test;

public class Day2Test {

    private static final String INPUT_1 = "1,0,0,0,99";
    private static final String INPUT_2 = "2,3,0,3,99";
    private static final String INPUT_3 = "2,4,4,5,99,0";
    private static final String INPUT_4 = "1,1,1,4,99,5,6,0,99";

    @Test
    public void testDay2() {
        Assert.assertTrue(Day2.calculate(INPUT_1.split(",")) == 2);
        Assert.assertTrue(Day2.calculate(INPUT_2.split(",")) == 2);
        Assert.assertTrue(Day2.calculate(INPUT_3.split(",")) == 2);
        Assert.assertTrue(Day2.calculate(INPUT_4.split(",")) == 30);
    }
}
