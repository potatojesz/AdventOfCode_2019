import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream stream = Main.class.getResourceAsStream("input.txt");
        List<String> wires = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while((line = reader.readLine()) != null) {
                if(StringUtils.isNotBlank(line)) {
                    wires.add(line);
                }
            }
        }
        System.out.println(WireUtils.distance(wires));
    }
}

