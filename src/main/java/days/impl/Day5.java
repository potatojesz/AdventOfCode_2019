package days.impl;

import days.Day;
import days.InjectDay;

@InjectDay
public class Day5 implements Day {
    @Override
    public int execute() {
        return 0;
    }

    @Override
    public Object input() {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(execute());
    }
}
