import java.util.ArrayList;
import java.util.Map;

public class Push implements Command {

    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params)
    {
        int valueWordIndex = 1;
        if(isNumeric(str[valueWordIndex]))
        {
            stack.add(Double.parseDouble(str[valueWordIndex]));
        }
        else {
            stack.add(params.get(str[valueWordIndex]));
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
