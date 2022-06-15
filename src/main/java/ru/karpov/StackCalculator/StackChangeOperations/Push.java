package ru.karpov.StackCalculator.StackChangeOperations;

import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

public final class Push implements Command {

    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> params)
    {
        final int valueWordIndex = 1;
        if(isNumeric(commandString[valueWordIndex]))
        {
            stack.push(Double.parseDouble(commandString[valueWordIndex]));
        }
        else {
            stack.push(params.get(commandString[valueWordIndex]));
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
