package ru.karpov.StackCalculator.StackChangeOperations;

import ru.karpov.StackCalculator.Command;
import ru.karpov.StackCalculator.Stack;

import java.util.Map;

public final class Pop implements Command {
    public void execute(String[] commandString, Stack stack, Map<String, Double> params)
    {
        stack.pop();
    }
}
