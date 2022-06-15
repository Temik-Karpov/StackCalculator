package ru.karpov.StackCalculator;
import java.util.Map;

public interface Command {
    void execute(final String[] commandString, final Stack stack, final Map<String, Double> parameters);
    default BinaryOperationArguments extractBinaryOperationArguments(final Stack stack)
    {
        final int minStackSize = 2;
        assert !(stack.getSize() < minStackSize);
        final BinaryOperationArguments binaryOperationArguments = new BinaryOperationArguments();
        binaryOperationArguments.setFirst_(getOperationArgument(stack));
        binaryOperationArguments.setSecond_(getOperationArgument(stack));
        return binaryOperationArguments;
    }

    private double getOperationArgument(Stack stack)
    {
        final double operationArgument = stack.getLastElement();
        stack.pop();
        return operationArgument;
    }
}
