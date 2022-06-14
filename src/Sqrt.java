import java.util.ArrayList;
import java.util.Map;

public class Sqrt implements Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        assert !stack.isEmpty();
        double number = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        stack.add(Math.sqrt(number));

    }
}

