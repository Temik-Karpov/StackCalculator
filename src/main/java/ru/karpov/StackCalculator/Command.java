package ru.karpov.StackCalculator;
import java.util.Map;

public abstract class Command {
    protected abstract void execute(final String[] commandString, final Stack stack, final Map<String, Double> parameters);
    protected final BinaryOperationArguments extractBinaryOperationArguments(final Stack stack)
    {
        final int minStackSize = 2;
        assert !(stack.getSize() < minStackSize);
        return new BinaryOperationArguments(
                getOperationArgument(stack), getOperationArgument(stack));
    }

    private double getOperationArgument(final Stack stack)
    {
        final double operationArgument = stack.getLastElement();
        stack.pop();
        return operationArgument;
    }
}
