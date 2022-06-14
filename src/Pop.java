import java.util.ArrayList;
import java.util.Map;

public class Pop implements Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        assert !stack.isEmpty();
        stack.remove(stack.size() - 1);
    }
}
