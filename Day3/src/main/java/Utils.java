import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private Utils() {}

    public static final String START = "o";
    public static final String HORIZONTAL = "-";
    public static final String VERTICAL = "|";
    public static final String CROSSED = "X";
    public static final String CHANGE_DIR = "+";

    public static final int manhatan(int startX, int startY, int x, int y) {
        return Math.abs(startX - x) + Math.abs(startY - y);
    }

    public List<List<String>> preparePlan(String[] input) {
        final List<List<String>> result = new ArrayList<>();
        List<String> column = new ArrayList<String>();
        column.add(START);
        result.add(column);

        for(int i = 0; i < input.length; i++) {
            switch(input[i].charAt(0)) {
                case 'R':
                    break;
                case 'L':
                    break;
                case 'U':
                    break;
                case 'D':
                    break;
                default:
                    throw new RuntimeException("Unreckognized option!");
            }
        }

        return result;
    }
}
