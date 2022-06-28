package ru.karpov.StackCalculator.stackChangeOperations;

import ru.karpov.StackCalculator.CommandDescription;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@CommandDescription(commandSymbol = "PUSH")
public final class Push extends Command {

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

    public static boolean isNumeric(String commandString) {
        try {
            Double.parseDouble(commandString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
