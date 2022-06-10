import java.util.Map;
import java.util.Stack;

public abstract class Command {
    public abstract void execute(String[] str, Stack<Double> stack, Map<String, Double> params);
}
