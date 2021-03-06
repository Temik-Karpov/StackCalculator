package ru.karpov.StackCalculator.arithmeticOperations;

import ru.karpov.StackCalculator.BinaryOperationArguments;
import ru.karpov.StackCalculator.CommandDescription;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@CommandDescription(commandSymbol = "+")
public final class Plus extends Command {
    public void execute(final String[] commandString, final Stack stack, final Map<String, Double> parameters)
    {
        BinaryOperationArguments binaryOperationArguments = extractBinaryOperationArguments(stack);
        stack.push(binaryOperationArguments.getFirst_() + binaryOperationArguments.getSecond_());
    }
}
