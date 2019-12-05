package days.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.io.Resources;
import days.Day;
import days.InjectDay;
import org.apache.commons.lang3.StringUtils;

@InjectDay
public class Day2_2 implements Day {
    private static final int DESIRED = 19690720;

    public static int calculate(int[] input) {
        for(int i = 0; i < input.length - 1; i = i + 4) {
            int code = input[i];
            if(code == 99) {
                return input[0];
            }
            int position1 = input[i + 1];
            int position2 = input[i + 2];
            int positionResult = input[i + 3];

            switch(code) {
                case 99:
                    return input[0];
                case 1: //Add
                    input[positionResult] = input[position1] + input[position2];
                    break;
                case 2: //Multiply
                    input[positionResult] = input[position1] * input[position2];
                    break;
                default:
                    Logger.getGlobal().log(Level.WARNING, "Invalid optcode!");
                    break;
            }
        }

        return input[0];
    }

    @Override
    public int execute() {
        int[] originalInput = Arrays.stream((String[]) input()).mapToInt(Integer::parseInt).toArray();
        final int length = originalInput.length;

        for(int i = 0; i < length - 1; i++) {
            for(int j = 0; j < length - 1; j++) {
                int[] copy = Arrays.copyOf(originalInput, length);
                copy[1] = i;
                copy[2] = j;
                if(calculate(copy) == 19690720) {
                    return 100 * i + j;
                }
            }
        }
        return -1;
    }

    @Override
    public Object input() {
        StringBuilder result = new StringBuilder();
        try(InputStream stream = Resources.getResource("input_day2.txt").openStream()) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                String line;
                while((line = reader.readLine()) != null) {
                    if(StringUtils.isNotBlank(line)) {
                        result.append(line);
                    }
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return result.toString().split(",");
    }

    @Override
    public String toString() {
        String result = "Day2 Answer: " + String.valueOf(execute());
        Logger.getGlobal().log(Level.INFO, result);

        return result;
    }
}
