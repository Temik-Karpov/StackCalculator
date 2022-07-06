import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpov.StackCalculator.StackCalculator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StackCalculatorTest {
    @Test
    void stackCommandExecuteTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, IOException {
        StackCalculator calc = new StackCalculator();
        calc.executeCommand("DEFINE a 4");
        calc.executeCommand("PUSH a");
        calc.executeCommand("PUSH 5");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 5);
        calc.executeCommand("POP");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 4);
        calc.executeCommand("PRINT");
        calc.executeCommand("# hello!");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 4);
    }



    @Test
    void arithmeticCommandTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, IOException {
        StackCalculator calc = new StackCalculator();
        calc.executeCommand("PUSH 4");
        calc.executeCommand("PUSH 5");
        calc.executeCommand("PUSH 6");
        calc.executeCommand("PUSH 7");
        calc.executeCommand("PUSH 8");
        calc.executeCommand("PUSH 9");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 9);
        calc.executeCommand("+");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 17);
        calc.executeCommand("-");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 10);
        calc.executeCommand("*");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 60);
        calc.executeCommand("/");
        Assertions.assertEquals(calc.getStack_().getLastElement(), 12);
        calc.executeCommand("SQRT");
    }
}
