package days.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.google.common.io.Resources;
import days.Day;
import days.InjectDay;
import org.apache.commons.lang3.StringUtils;

@InjectDay
public class Day1 implements Day {

    public static int calculate(int mass) {
        return mass / 3 - 2;
    }

    @Override
    public int execute() {
        String[] arr = (String[]) input();
        List<Integer> results = Arrays.stream(arr).map(s -> calculate(Integer.parseInt(s))).collect(Collectors.toList());
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public Object input() {
        StringBuilder result = new StringBuilder();
        try(InputStream stream = Resources.getResource("input_day1.txt").openStream()) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                String line;
                while((line = reader.readLine()) != null) {
                    if(StringUtils.isNotBlank(line) && StringUtils.isNumeric(line)) {
                        result.append(line).append(",");
                    }
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return result.substring(0, result.length() - 1).split(",");
    }

    @Override
    public String toString() {
        String result = "Day1 Answer: " + String.valueOf(execute());
        Logger.getGlobal().log(Level.INFO, result);

        return result;
    }
}
