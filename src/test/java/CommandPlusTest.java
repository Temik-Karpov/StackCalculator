import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.arithmeticOperations.Plus;
import ru.karpov.StackCalculator.Stack;

import java.util.HashMap;
import java.util.Map;

public class CommandPlusTest {

    @Test
    void nullStringAndMapTest()
    {
        Plus plusCommand = new Plus();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        plusCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 5);
    }

    @Test
    void threeSizeStackTest()
    {
        Plus plusCommand = new Plus();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        plusCommand.execute(new String[]{"+"}, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 7);
    }

    @Test
    void notEmptyMapTest()
    {
        Plus plusCommand = new Plus();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        plusCommand.execute(new String[]{"+"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 7);
    }
}
