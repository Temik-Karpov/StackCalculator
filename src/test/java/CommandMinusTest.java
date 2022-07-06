import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.arithmeticOperations.Minus;
import ru.karpov.StackCalculator.Stack;

import java.util.HashMap;
import java.util.Map;

public final class CommandMinusTest {
    @Test
    void nullStringAndMapTest()
    {
        Minus minusCommand = new Minus();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        minusCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 1);
    }

    @Test
    void threeSizeStackTest()
    {
        Minus minusCommand = new Minus();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        minusCommand.execute(new String[]{"-"}, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 1);
    }

    @Test
    void notEmptyMapTest()
    {
        Minus minusCommand = new Minus();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        minusCommand.execute(new String[]{"-"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 1);
    }
}
