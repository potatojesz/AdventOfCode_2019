import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream stream = Main.class.getResourceAsStream("input.txt");
        final StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while((line = reader.readLine()) != null) {
                if(StringUtils.isNotBlank(line)) {
                    sb.append(line);
                }
            }
        }
        final String[] input = sb.toString().split(",");
        System.out.println(Computer.execute(input));
    }
}
