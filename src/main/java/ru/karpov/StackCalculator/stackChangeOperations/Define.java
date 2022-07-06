package ru.karpov.StackCalculator.stackChangeOperations;

import ru.karpov.StackCalculator.CommandDescription;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@CommandDescription(commandSymbol = "DEFINE")
public final class Define extends Command {
    @Override
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> parameters) {
        final int keyWordIndex = 1;
        final int valueWordIndex = 2;
        parameters.put(commandString[keyWordIndex], Double.parseDouble(commandString[valueWordIndex]));
    }
}
