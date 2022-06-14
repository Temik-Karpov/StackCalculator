import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Sqrt extends Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        assert !stack.isEmpty();
        stack.add(Math.sqrt(stack.get(stack.size() - 1)));
        stack.remove(stack.size() - 1);
    }
}

