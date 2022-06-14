import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandDefineTest {
    @Test
    void EmptyMapTest()
    {
        Define defineCommand = new Define();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        Map<String, Double> map = new HashMap<>();
        defineCommand.execute(new String[]{"DEFINE", "a", "4"}, stack, map);
    }

    @Test
    void nullStackTest()
    {
        Define defineCommand = new Define();
        Map<String, Double> map = new HashMap<>();
        defineCommand.execute(new String[]{"DEFINE", "a", "4"}, null, map);
    }

    @Test
    void notEmptyMapTest()
    {
        Define defineCommand = new Define();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        defineCommand.execute(new String[]{"DEFINE", "b", "5"}, stack, map);
    }
}
