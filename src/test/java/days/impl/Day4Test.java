package days.impl;

import org.junit.Assert;
import org.junit.Test;

public class Day4Test {

    @Test
    public void testIncrease() {
        int test1 = 1223456;
        int test2 = 2123414;

        Assert.assertTrue(Day4.checkIncrease(test1));
        Assert.assertFalse(Day4.checkIncrease(test2));
    }

    @Test
    public void testAtLeastTwoDigitsSame() {
        int test1 = 1223456;
        int test2 = 2123414;

        Assert.assertTrue(Day4.checkAtLeastTwoSameDigits(test1));
        Assert.assertFalse(Day4.checkAtLeastTwoSameDigits(test2));
    }

    @Test
    public void testIfThereAreTwoSameDigits() {
        int test1 = 1223456;
        int test2 = 2123414;
        int test3 = 111122;
        int test4 = 12223456;

        //Assert.assertTrue(Day4_2.checkIfThereAreTwoSameDigits(test1));
        //Assert.assertFalse(Day4_2.checkIfThereAreTwoSameDigits(test2));
        Assert.assertTrue(Day4_2.checkIfThereAreTwoSameDigits(test3));
        //Assert.assertFalse(Day4_2.checkIfThereAreTwoSameDigits(test4));
    }
}
