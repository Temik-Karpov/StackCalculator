package ru.karpov.StackCalculator.stackChangeOperations;

import ru.karpov.StackCalculator.CommandDescription;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@CommandDescription(commandSymbol = "POP")
public final class Pop extends Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> parameters)
    {
        stack.pop();
    }
}
