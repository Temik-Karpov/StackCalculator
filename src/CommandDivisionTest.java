import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandDivisionTest {

    @Test
    void nullStringAndMapTest()
    {
        Division divisionCommand = new Division();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        divisionCommand.execute(null, stack, null);
    }

    @Test
    void threeSizeStackTest()
    {
        Division divisionCommand = new Division();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        divisionCommand.execute(new String[]{"/"}, stack, null);
    }

    @Test
    void notEmptyMapTest()
    {
        Division divisionCommand = new Division();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        divisionCommand.execute(new String[]{"/"}, stack, map);
    }
}
