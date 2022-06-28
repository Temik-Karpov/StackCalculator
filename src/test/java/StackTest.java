import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.Stack;

public final class StackTest {
    @Test
    void functionsPushAndGetLastElementTest()
    {
        final Stack stack = new Stack();
        stack.push(4);
        Assertions.assertEquals(stack.getLastElement(), 4);
        stack.push(3);
        Assertions.assertEquals(stack.getLastElement(), 3);
    }

    @Test
    void functionsPushAndPopTest()
    {
        final Stack stack = new Stack();
        stack.push(4);
        stack.push(3);
        stack.pop();
        Assertions.assertEquals(stack.getLastElement(), 4);
    }

    @Test
    void functionsPushAndGetSizeTest()
    {
        final Stack stack = new Stack();
        stack.push(4);
        stack.push(3);
        Assertions.assertEquals(stack.getSize(), 2);
    }
}
