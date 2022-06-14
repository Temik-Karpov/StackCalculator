import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Division extends Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        int minStackSize = 2;
        assert !(stack.size() < minStackSize);
        double firstNumber = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        assert stack.get(stack.size() - 1) != 0;
        double secondNumber = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        stack.add(firstNumber / secondNumber);
    }
}
