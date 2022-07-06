import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.Stack;
import ru.karpov.StackCalculator.stackExtraOperations.Comment;

import java.util.HashMap;
import java.util.Map;

public final class CommandCommentTest {
    @Test
    void nullStringAndMapTest()
    {
        Comment commentCommand = new Comment();
        Stack stack = new Stack();
        stack.push(4.0);
        commentCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 4);
    }

    @Test
    void twoSizeStackTest()
    {
        Comment commentCommand = new Comment();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(9.0);
        commentCommand.execute(new String[]{"#", "hello"}, stack, null);
        Assertions.assertEquals(stack.getLastElement(), 9);
    }

    @Test
    void notEmptyMapTest()
    {
        Comment commentCommand = new Comment();
        Stack stack = new Stack();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        commentCommand.execute(new String[]{"#", "hello"}, stack, map);
        Assertions.assertEquals(stack.getLastElement(), 4);
    }
}
