package ru.karpov.StackCalculator;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StackCalc {
    static final Logger log = Logger.getGlobal();
    private final Stack stack_ = new Stack();
    private final Map<String, Double> params_ = new HashMap<>();

    public void fileParser(final FileReader fileReader) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        final BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            log.info("Parse command " + line);
            executeCommand(line);
            line = reader.readLine();
        }
    }

    public void start(final String fileName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        log.info("Check file name");
        if(fileName.length() != 0)
        {
            log.info("Start read file");
            readFile(fileName);
        }
        else
        {
            log.info("Start console input");
            consoleInput();
        }
    }

    public void consoleInput() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        final Scanner scan = new Scanner(System.in);
        final String str = scan.nextLine();
        log.info("The command is accepted. Start parser");
        executeCommand(str);
    }

    public void readFile(final String fileName)
    {
        try
        {
            final File file = new File(fileName);
            final FileReader fileReader = new FileReader(file);
            fileParser(fileReader);
            log.info("Start file parser");
        } catch (IOException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            log.log(Level.WARNING, "File problem", e);
        }
    }

    public Command commandParser(String commandFirstWord) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Command command = null;
        AccessingAllClassesInPackage instance = new AccessingAllClassesInPackage();
        Set<Class<?>> classes = instance.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.ArithmeticOperations");
        classes.addAll(instance.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.StackChangeOperations"));
        classes.addAll(instance.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.StackExtraOperations"));
        for(Class<?> cl : classes)
        {
            ClassNameAnnotation annotation = cl.getAnnotation(ClassNameAnnotation.class);
            if(commandFirstWord.equals(annotation.name()))
            {
                command = (Command) cl.getDeclaredConstructor().newInstance();
                return command;
            }
        }
        return null;
    }

    public void executeCommand(String commandString) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final String[] words = commandString.split(" ");
        final String commandFirstWord = words[0];
        Command command = commandParser(commandFirstWord);
        assert command != null;
        log.info("Parser is complete. Start execute");
        try {
            command.execute(words, this.stack_, this.params_);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            log.log(Level.WARNING, "Command execute problem", e);
        }
    }
}
