import java.util.Map;
import java.util.Stack;

public class Pop extends Command{
    public void execute(String[] str, Stack<Double> stack, Map<String, Double> params)
    {
        assert stack.empty();
        stack.pop();
    }
}
