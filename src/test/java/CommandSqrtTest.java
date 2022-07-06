import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.arithmeticOperations.Sqrt;
import ru.karpov.StackCalculator.Stack;

import java.util.HashMap;
import java.util.Map;

public final class CommandSqrtTest {
    @Test
    void nullStringAndMapTest()
    {
        Sqrt sqrtCommand = new Sqrt();
        Stack stack = new Stack();
        stack.push(4.0);
        sqrtCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 2);
    }

    @Test
    void twoSizeStackTest()
    {
        Sqrt sqrtCommand = new Sqrt();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(9.0);
        sqrtCommand.execute(new String[]{"PUSH", "4"}, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 3);
    }

    @Test
    void notEmptyMapTest()
    {
        Sqrt sqrtCommand = new Sqrt();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        sqrtCommand.execute(new String[]{"+"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 2);
    }
}
