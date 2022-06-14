import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandPopTest {
    @Test
    void nullStringAndMapTest()
    {
        Pop popCommand = new Pop();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        popCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.get(stack.size() - 1), 2);
    }

    @Test
    void oneSizeStackTest()
    {
        Pop popCommand = new Pop();
        Map<String, Double> map = new HashMap<>();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        popCommand.execute(new String[]{"POP"}, stack, map);
        Assertions.assertEquals(stack.size(), 0);
    }

    @Test
    void notEmptyMapTest()
    {
        Pop popCommand = new Pop();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        popCommand.execute(new String[]{"POP"}, stack, map);
        Assertions.assertEquals(stack.get(stack.size() - 1), 3);
    }
}
