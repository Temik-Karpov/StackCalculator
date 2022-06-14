import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Pop extends Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        assert !stack.isEmpty();
        stack.remove(stack.size() - 1);
    }
}
