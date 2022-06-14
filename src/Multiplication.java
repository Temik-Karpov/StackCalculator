import java.util.ArrayList;
import java.util.Map;

public class Multiplication implements Command{
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        Double[] numbers = getNumbers(stack);
        int indexFirstNumber = 0;
        int indexSecondNumber = 1;
        stack.add(numbers[indexFirstNumber] * numbers[indexSecondNumber]);
    }
}
