import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import days.Day;
import days.InjectDay;
import org.reflections.Reflections;

public final class Utils {
    private Utils() {}

    public static Set<Day> getDays() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Set<Day> result = new HashSet<>();
        final Reflections reflections = new Reflections();
        final Set<Class<?>> daysClass = reflections.getTypesAnnotatedWith(InjectDay.class);
        for (final Class<?> dayClass : daysClass) {
            final Constructor<?> namedConstructor = dayClass.getConstructor();
            Logger.getGlobal().log(Level.INFO, dayClass.getSimpleName() + " added to scope.");
            result.add((Day)namedConstructor.newInstance());
        }
        return result;
    }
}
