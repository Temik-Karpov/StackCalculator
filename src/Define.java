import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Define extends Command {
    @Override
    public void execute(String[] str, ArrayList<Double> stack, Map<String, Double> params) {
        int keyWordIndex = 1;
        int valueWordIndex = 2;
        params.put(str[keyWordIndex], Double.parseDouble(str[valueWordIndex]));
    }
}
