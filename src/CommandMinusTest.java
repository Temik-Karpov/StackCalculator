import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandMinusTest {
    @Test
    void nullStringAndMapTest()
    {
        Minus minusCommand = new Minus();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        minusCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.get(stack.size() - 1), 1);
    }

    @Test
    void threeSizeStackTest()
    {
        Minus minusCommand = new Minus();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        minusCommand.execute(new String[]{"-"}, stack, null);
        Assertions.assertEquals(stack.get(stack.size() - 1), 1);
    }

    @Test
    void notEmptyMapTest()
    {
        Minus minusCommand = new Minus();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        minusCommand.execute(new String[]{"-"}, stack, map);
        Assertions.assertEquals(stack.get(stack.size() - 1), 1);
    }
}
