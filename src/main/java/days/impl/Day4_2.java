package days.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import days.Day;
import days.InjectDay;

@InjectDay
public class Day4_2 implements Day {

    public static int howManyPasswords(int min, int max) {
        int counter = 0;
        for(int i = min; i <= max; i++) {
            if(checkIncrease(i) && checkIfThereAreTwoSameDigits(i)) {
                counter++;
            }
        }

        return counter;
    }

    public static boolean checkIfThereAreTwoSameDigits(int number) {
        String string = String.valueOf(number);
        int last = Integer.parseInt(String.valueOf(string.charAt(0)));
        Set<Integer> counters = new HashSet<>();
        int counter = 1;
        for(int i = 1; i < string.length(); i++) {
            int next = Integer.parseInt(String.valueOf(string.charAt(i)));
            if(last == next) {
                counter++;
            } else {
                counters.add(counter);
                counter = 1;
            }
            last = next;
        }
        counters.add(counter);
        return counters.contains(2);
    }

    public static boolean checkIncrease(int number) {
        String string = String.valueOf(number);
        int last = Integer.parseInt(String.valueOf(string.charAt(0)));
        for(int i = 1; i < string.length(); i++) {
            int next = Integer.parseInt(String.valueOf(string.charAt(i)));
            if(last > next) {
                return false;
            }
            last = next;
        }

        return true;
    }

    @Override
    public int execute() {
        String[] minmax = input().toString().split("-");
        return howManyPasswords(Integer.parseInt(minmax[0]), Integer.parseInt(minmax[1]));
    }

    @Override
    public Object input() {
        return "356261-846303";
    }

    @Override
    public String toString() {
        String result = "Day4 Answer: " + execute();
        Logger.getGlobal().log(Level.INFO, result);

        return result;
    }
}
