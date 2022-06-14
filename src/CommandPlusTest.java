import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandPlusTest {

    @Test
    void nullStringAndMapTest()
    {
        Plus plusCommand = new Plus();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        plusCommand.execute(null, stack, null);
    }

    @Test
    void threeSizeStackTest()
    {
        Plus plusCommand = new Plus();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        plusCommand.execute(new String[]{"+"}, stack, null);
    }

    @Test
    void notEmptyMapTest()
    {
        Plus plusCommand = new Plus();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        plusCommand.execute(new String[]{"+"}, stack, map);
    }
}
