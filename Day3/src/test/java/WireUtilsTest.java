import java.util.List;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

public class WireUtilsTest {
    private static final List<String> INPUT_DUMMY =  Lists.newArrayList("R8,U5,L5,D3",
            "U7,R6,D4,L4");

    private static final List<String> INPUT_1 =  Lists.newArrayList("R75,D30,R83,U83,L12,D49,R71,U7,L72",
            "U62,R66,U55,R34,D71,R55,D58,R83");

    private static final List<String> INPUT_2 = Lists.newArrayList("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
    "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");


    @Test
    public void testIntersections() {
        Assert.assertEquals(6, WireUtils.distance(INPUT_DUMMY));
        Assert.assertEquals(159, WireUtils.distance(INPUT_1));
        Assert.assertEquals(135, WireUtils.distance(INPUT_2));
    }
}
