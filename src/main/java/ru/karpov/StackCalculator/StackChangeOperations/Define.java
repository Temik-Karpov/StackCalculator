package ru.karpov.StackCalculator.StackChangeOperations;

import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

public final class Define implements Command {
    @Override
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> params) {
        final int keyWordIndex = 1;
        final int valueWordIndex = 2;
        params.put(commandString[keyWordIndex], Double.parseDouble(commandString[valueWordIndex]));
    }
}
