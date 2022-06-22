package ru.karpov.StackCalculator.arithmeticOperations;

import ru.karpov.StackCalculator.ClassNameAnnotation;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@ClassNameAnnotation(name = "SQRT")
public final class Sqrt implements Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> params)
    {
        final double number = stack.getLastElement();
        stack.pop();
        stack.push(Math.sqrt(number));
    }
}

