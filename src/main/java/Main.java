import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import days.Day;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Set<Day> days = Utils.getDays();
        days.stream().forEach(Day::toString);
    }
}
