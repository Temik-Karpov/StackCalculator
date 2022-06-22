import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.arithmeticOperations.Multiplication;
import ru.karpov.StackCalculator.Stack;

import java.util.HashMap;
import java.util.Map;

public class CommandMultiplicationTest {
    @Test
    void nullStringAndMapTest()
    {
        Multiplication multiplicationCommand = new Multiplication();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        multiplicationCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 6);
    }

    @Test
    void threeSizeStackTest()
    {
        Multiplication multiplicationCommand = new Multiplication();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        multiplicationCommand.execute(new String[]{"*"}, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 12);
    }

    @Test
    void notEmptyMapTest()
    {
        Multiplication multiplicationCommand = new Multiplication();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        multiplicationCommand.execute(new String[]{"*"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 12);
    }
}
