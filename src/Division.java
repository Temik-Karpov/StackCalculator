import java.util.Map;
import java.util.Stack;

public class Division extends Command{
    public void execute(String[] str, Stack<Double> stack, Map<String, Double> params)
    {
        assert stack.size() < 2;
        stack.push(stack.pop() / stack.pop());
    }
}
