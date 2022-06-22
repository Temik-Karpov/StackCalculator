package ru.karpov.StackCalculator.arithmeticOperations;

import ru.karpov.StackCalculator.BinaryOperationArguments;
import ru.karpov.StackCalculator.ClassNameAnnotation;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@ClassNameAnnotation(name = "+")
public final class Plus implements Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> params)
    {
        BinaryOperationArguments binaryOperationArguments = extractBinaryOperationArguments(stack);
        stack.push(binaryOperationArguments.getFirst_() + binaryOperationArguments.getSecond_());
    }
}
