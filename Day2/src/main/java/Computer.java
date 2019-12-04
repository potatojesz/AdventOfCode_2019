import java.util.logging.Level;
import java.util.logging.Logger;

public final class Computer {
    private Computer() {}

    public static int execute(String[] input) {
        for(int i = 0; i < input.length; i=i+4) {
            int code = Integer.parseInt(input[i]);
            int position1 = Integer.parseInt(input[i+1]);
            int position2 = Integer.parseInt(input[i+2]);
            int positionResult = Integer.parseInt(input[i+3]);

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
        throw new RuntimeException("Input never halts!");
    }
}
