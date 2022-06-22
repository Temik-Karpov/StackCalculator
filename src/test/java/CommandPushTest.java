import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.Stack;
import ru.karpov.StackCalculator.stackChangeOperations.Push;

import java.util.HashMap;
import java.util.Map;

public class CommandPushTest {
    @Test
    void nullMapTest()
    {
        Push pushCommand = new Push();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        pushCommand.execute(new String[]{"PUSH", "4"}, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 4);
    }

    @Test
    void oneSizeStackTest()
    {
        Push pushCommand = new Push();
        Map<String, Double> map = new HashMap<>();
        Stack stack = new Stack();
        stack.push(2.0);
        pushCommand.execute(new String[]{"PUSH", "4"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 4);
    }

    @Test
    void notEmptyMapTest()
    {
        Push pushCommand = new Push();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        pushCommand.execute(new String[]{"PUSH", "a"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 4);
    }
}
