import java.util.ArrayList;
import java.util.Map;

public class Print implements Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        assert !stack.isEmpty();
        System.out.println(stack.get(stack.size() - 1));
    }
}
