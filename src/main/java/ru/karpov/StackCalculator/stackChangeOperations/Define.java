package ru.karpov.StackCalculator.stackChangeOperations;

import ru.karpov.StackCalculator.ClassNameAnnotation;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@ClassNameAnnotation(name = "DEFINE")
public final class Define implements Command {
    @Override
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> params) {
        final int keyWordIndex = 1;
        final int valueWordIndex = 2;
        params.put(commandString[keyWordIndex], Double.parseDouble(commandString[valueWordIndex]));
    }
}
