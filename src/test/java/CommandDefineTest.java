import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.Stack;
import ru.karpov.StackCalculator.stackChangeOperations.Define;

import java.util.HashMap;
import java.util.Map;

public final class CommandDefineTest {
    @Test
    void EmptyMapTest()
    {
        Define defineCommand = new Define();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        Map<String, Double> map = new HashMap<>();
        defineCommand.execute(new String[]{"DEFINE", "a", "4"}, stack, map);
        Assertions.assertEquals(map.get("a"), 4);
    }

    @Test
    void nullStackTest()
    {
        Define defineCommand = new Define();
        Map<String, Double> map = new HashMap<>();
        defineCommand.execute(new String[]{"DEFINE", "a", "4"}, null, map);
        Assertions.assertEquals(map.get("a"), 4);
    }

    @Test
    void notEmptyMapTest()
    {
        Define defineCommand = new Define();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        defineCommand.execute(new String[]{"DEFINE", "b", "5"}, stack, map);
        Assertions.assertEquals(map.get("a"), 4);
    }
}
