import java.util.ArrayList;
import java.util.Map;

public interface Command {
    void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params);
    default Double[] getNumbers(ArrayList<Double> stack)
    {
        int minStackSize = 2;
        assert !(stack.size() < minStackSize);
        double firstNumber = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        double secondNumber = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return new Double[]{firstNumber, secondNumber};
    }
}
