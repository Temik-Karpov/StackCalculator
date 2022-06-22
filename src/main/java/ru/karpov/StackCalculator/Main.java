package ru.karpov.StackCalculator;

import ru.karpov.StackCalculator.StackCalc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final Logger log = Logger.getGlobal();
    static Handler fh;

    static {
        try {
            fh = new FileHandler("log.txt");
            log.addHandler(fh);
            log.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        log.info("Start program");
        StackCalc calc = new StackCalc();
        calc.start("input.txt");
    }
}
