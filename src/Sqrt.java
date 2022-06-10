import java.util.Map;
import java.util.Stack;

public class Sqrt extends Command{
    public void execute(String[] str, Stack<Double> stack, Map<String, Double> params)
    {
        assert !stack.empty();
        stack.push(Math.sqrt(stack.pop()));
    }
}

