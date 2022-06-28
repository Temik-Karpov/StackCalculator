package ru.karpov.StackCalculator;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static final Logger log = Logger.getGlobal();

    static {
        try {
            final Handler fh = new FileHandler("log.txt");
            log.addHandler(fh);
            log.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Main()
    { }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, IOException {
        log.info("Start program");
        final StackCalculator calc = new StackCalculator();
        calc.start("input.txt");
    }
}
