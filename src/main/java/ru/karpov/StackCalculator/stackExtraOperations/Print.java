package ru.karpov.StackCalculator.stackExtraOperations;

import ru.karpov.StackCalculator.ClassNameAnnotation;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@ClassNameAnnotation(name = "PRINT")
public final class Print implements Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> params)
    {
        stack.printLastElement();
    }
}
