import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream stream = Main.class.getResourceAsStream("input.txt");
        final List<Integer> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while((line = reader.readLine()) != null) {
                if(StringUtils.isNotBlank(line) && StringUtils.isNumeric(line)) {
                    results.add(FuelCalculator.calculate(Integer.parseInt(line)));
                } else {
                    Logger.getGlobal().log(Level.WARNING,"Input is empty or nor numeric: " + line);
                }
            }
        }
        System.out.println(results.stream().mapToInt(Integer::intValue).sum());
    }
}
