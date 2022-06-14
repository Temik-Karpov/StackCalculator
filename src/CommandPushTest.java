import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandPushTest {
    @Test
    void nullMapTest()
    {
        Push pushCommand = new Push();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        pushCommand.execute(new String[]{"PUSH", "4"}, stack, null);
    }

    @Test
    void oneSizeStackTest()
    {
        Push pushCommand = new Push();
        Map<String, Double> map = new HashMap<>();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        pushCommand.execute(new String[]{"PUSH", "4"}, stack, map);
    }

    @Test
    void notEmptyMapTest()
    {
        Push pushCommand = new Push();
        ArrayList<Double> stack = new ArrayList<>();
        stack.add(2.0);
        stack.add(3.0);
        stack.add(4.0);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 4.0);
        pushCommand.execute(new String[]{"PUSH", "a"}, stack, map);
    }
}
