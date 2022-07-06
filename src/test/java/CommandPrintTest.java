import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.Stack;
import ru.karpov.StackCalculator.stackExtraOperations.Print;

import java.util.HashMap;
import java.util.Map;

public final class CommandPrintTest {
    @Test
    void nullStringAndMapTest()
    {
        Print printCommand = new Print();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        printCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 3);
    }

    @Test
    void oneSizeStackTest()
    {
        Print printCommand = new Print();
        Map<String, Double> map = new HashMap<>();
        Stack stack = new Stack();
        stack.push(2.0);
        printCommand.execute(new String[]{"PRINT"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 2);
    }

    @Test
    void notEmptyMapTest()
    {
        Print printCommand = new Print();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        printCommand.execute(new String[]{"PRINT"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 4);
    }
}
