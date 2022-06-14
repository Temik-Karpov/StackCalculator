import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandPrintTest {
    @Test
    void nullStringAndMapTest()
    {
        Print printCommand = new Print();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        printCommand.execute(null, stack, null);
        Assertions.assertEquals(stack.get(stack.size() - 1), 3);
    }

    @Test
    void oneSizeStackTest()
    {
        Print printCommand = new Print();
        Map<String, Double> map = new HashMap<>();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        printCommand.execute(new String[]{"PRINT"}, stack, map);
        Assertions.assertEquals(stack.get(stack.size() - 1), 2);
    }

    @Test
    void notEmptyMapTest()
    {
        Print printCommand = new Print();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        printCommand.execute(new String[]{"PRINT"}, stack, map);
        Assertions.assertEquals(stack.get(stack.size() - 1), 4);
    }
}
