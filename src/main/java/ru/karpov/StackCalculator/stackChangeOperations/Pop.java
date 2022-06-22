package ru.karpov.StackCalculator.stackChangeOperations;

import ru.karpov.StackCalculator.ClassNameAnnotation;
import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

@ClassNameAnnotation(name = "POP")
public final class Pop implements Command {
    public void execute(String[] commandString, Stack stack, Map<String, Double> params)
    {
        stack.pop();
    }
}
