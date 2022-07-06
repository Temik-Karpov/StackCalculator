package ru.karpov.StackCalculator.arithmeticOperations;

import ru.karpov.StackCalculator.CommandDescription;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@CommandDescription(commandSymbol = "SQRT")
public final class Sqrt extends Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> parameters)
    {
        final double number = stack.getLastElement();
        stack.pop();
        stack.push(Math.sqrt(number));
    }
}

