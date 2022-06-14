import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Minus extends Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        int minStackSize = 2;
        assert !(stack.size() < minStackSize);
        double firstNumber = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        double secondNumber = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        stack.add(firstNumber - secondNumber);
    }
}
