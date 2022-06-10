import java.util.Map;
import java.util.Stack;

public class Print extends Command{
    public void execute(String[] str, Stack<Double> stack, Map<String, Double> params)
    {
        assert !stack.empty();
        System.out.println(stack.peek());
    }
}
