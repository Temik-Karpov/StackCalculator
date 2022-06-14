import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandSqrtTest {
    @Test
    void nullStringAndMapTest()
    {
        Sqrt sqrtCommand = new Sqrt();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        sqrtCommand.execute(null, stack, null);
    }

    @Test
    void twoSizeStackTest()
    {
        Sqrt sqrtCommand = new Sqrt();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        sqrtCommand.execute(new String[]{"PUSH", "4"}, stack, null);
    }

    @Test
    void notEmptyMapTest()
    {
        Sqrt sqrtCommand = new Sqrt();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        sqrtCommand.execute(new String[]{"+"}, stack, map);
    }
}
