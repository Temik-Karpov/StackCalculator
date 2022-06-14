import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public abstract class Command {
    public abstract void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params);
}
