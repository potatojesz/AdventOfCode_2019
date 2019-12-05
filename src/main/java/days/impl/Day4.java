package days.impl;

import days.Day;
import days.InjectDay;

@InjectDay
public class Day4 implements Day {
    @Override
    public int execute() {
        return 0;
    }

    @Override
    public Object input() {
        return "356261-846303";
    }

    @Override
    public String toString() {
        return String.valueOf(execute());
    }
}
