import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Define extends Command {
    @Override
    public void execute(String[] str, Stack<Double> stack, Map<String, Double> params) {
        params.put(str[1], Double.parseDouble(str[2]));
    }
}
