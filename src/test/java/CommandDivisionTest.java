import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.ArithmeticOperations.Division;
import ru.karpov.StackCalculator.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandDivisionTest {

    @Test
    void nullStringAndMapTest()
    {
        Division divisionCommand = new Division();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(6.0);
        divisionCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 3);
    }

    @Test
    void threeSizeStackTest()
    {
        Division divisionCommand = new Division();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(9.0);
        divisionCommand.execute(new String[]{"/"}, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 3);
    }

    @Test
    void notEmptyMapTest()
    {
        Division divisionCommand = new Division();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(9.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        divisionCommand.execute(new String[]{"/"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 3);
    }
}
