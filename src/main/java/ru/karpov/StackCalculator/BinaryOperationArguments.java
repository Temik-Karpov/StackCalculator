package ru.karpov.StackCalculator;

public final class BinaryOperationArguments
{
    private final double first_;
    private final double second_;

    public BinaryOperationArguments(final double first_, final double second_)
    {
        this.first_ = first_;
        this.second_ = second_;
    }

    public double getFirst_() {
        return first_;
    }

    public double getSecond_() {
        return second_;
    }
}