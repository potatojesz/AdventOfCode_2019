package days.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.io.Resources;
import days.Day;
import days.InjectDay;
import org.apache.commons.lang3.StringUtils;

@InjectDay
public class Day2 implements Day {

    public static int calculate(String[] input) {
        for(int i = 0; i < input.length - 1; i = i + 4) {
            int code = Integer.parseInt(input[i]);
            if(code == 99) {
                return Integer.parseInt(input[0]);
            }
            int position1 = Integer.parseInt(input[i + 1]);
            int position2 = Integer.parseInt(input[i + 2]);
            int positionResult = Integer.parseInt(input[i + 3]);

            switch(code) {
                case 99:
                    return Integer.parseInt(input[0]);
                case 1: //Add
                    input[positionResult] = String.valueOf(Integer.parseInt(input[position1]) + Integer.parseInt(input[position2]));
                    break;
                case 2: //Multiply
                    input[positionResult] = String.valueOf(Integer.parseInt(input[position1]) * Integer.parseInt(input[position2]));
                    break;
                default:
                    Logger.getGlobal().log(Level.WARNING, "Invalid optcode!");
                    break;
            }
        }

        return Integer.parseInt(input[0]);
    }

    @Override
    public int execute() {
        return calculate((String[]) input());
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
