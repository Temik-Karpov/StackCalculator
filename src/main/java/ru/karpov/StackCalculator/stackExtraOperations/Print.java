package ru.karpov.StackCalculator.stackExtraOperations;

import ru.karpov.StackCalculator.CommandDescription;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@CommandDescription(commandSymbol = "PRINT")
public final class Print extends Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> parameters)
    {
        stack.printLastElement();
    }
}
