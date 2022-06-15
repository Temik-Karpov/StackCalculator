package ru.karpov.StackCalculator.ArithmeticOperations;

import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

public final class Sqrt implements Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> params)
    {
        final double number = stack.getLastElement();
        stack.pop();
        stack.push(Math.sqrt(number));
    }
}

