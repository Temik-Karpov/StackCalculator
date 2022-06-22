import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.Stack;
import ru.karpov.StackCalculator.stackChangeOperations.Pop;

import java.util.HashMap;
import java.util.Map;

public class CommandPopTest {
    @Test
    void nullStringAndMapTest()
    {
        Pop popCommand = new Pop();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        popCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 2);
    }

    @Test
    void oneSizeStackTest()
    {
        Pop popCommand = new Pop();
        Map<String, Double> map = new HashMap<>();
        Stack stack = new Stack();
        stack.push(2.0);
        popCommand.execute(new String[]{"POP"}, stack, map);
        Assertions.assertEquals(stack.getSize(), 0);
    }

    @Test
    void notEmptyMapTest()
    {
        Pop popCommand = new Pop();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        popCommand.execute(new String[]{"POP"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 3);
    }
}
