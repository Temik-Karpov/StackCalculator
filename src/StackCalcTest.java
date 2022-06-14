import org.junit.jupiter.api.Test;

public class StackCalcTest {
    @Test
    void stackCommandExecuteTest()
    {
        StackCalc calc = new StackCalc();
        calc.executeCommand("DEFINE a 4");
        calc.executeCommand("PUSH a");
        calc.executeCommand("PUSH 5");
        calc.executeCommand("POP");
        calc.executeCommand("PRINT");
        calc.executeCommand("# hello!");
    }

    @Test
    void arithmeticCommandTest()
    {
        StackCalc calc = new StackCalc();
        calc.executeCommand("PUSH 4");
        calc.executeCommand("PUSH 5");
        calc.executeCommand("PUSH 6");
        calc.executeCommand("PUSH 7");
        calc.executeCommand("PUSH 8");
        calc.executeCommand("PUSH 9");
        calc.executeCommand("+");
        calc.executeCommand("-");
        calc.executeCommand("*");
        calc.executeCommand("/");
        calc.executeCommand("SQRT");
    }
}
