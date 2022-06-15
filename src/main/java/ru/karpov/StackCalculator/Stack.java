package ru.karpov.StackCalculator;

import java.util.ArrayList;

public final class Stack {
    private final ArrayList<Double> list_ = new ArrayList<>();

    public void pop()
    {
        assert !this.list_.isEmpty();
        this.list_.remove(this.list_.size() - 1);
    }

    public void push(final double newNumberInStack)
    {
        this.list_.add(newNumberInStack);
    }

    public void printLastElement()
    {
        assert !this.list_.isEmpty();
        System.out.println(this.list_.get(this.list_.size() - 1));
    }

    public double getLastElement()
    {
        return this.list_.get(this.list_.size() - 1);
    }

    public int getSize()
    {
        return this.list_.size();
    }
}
