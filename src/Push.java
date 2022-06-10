import java.util.Map;
import java.util.Stack;

public class Push extends Command {

    public void execute(String[] str, Stack<Double> stack, Map<String, Double> params)
    {
        if(isNumeric(str[1]))
        {
            stack.push(Double.parseDouble(str[1]));
        }
        else {
            stack.push(params.get(str[1]));
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
