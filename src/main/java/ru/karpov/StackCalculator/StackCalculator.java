package ru.karpov.StackCalculator;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StackCalculator {
    static final Logger log = Logger.getGlobal();
    private final Stack stack_ = new Stack();
    private final Map<String, Double> parameters_ = new HashMap<>();

    public void parseFile(final FileReader fileReader) throws IOException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        final BufferedReader reader = new BufferedReader(fileReader);
        try (reader) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                log.info("Parse command " + line);
                executeCommand(line);
                line = reader.readLine();
            }
        }
    }

    public void start(final String fileName) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, IOException {
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

    private void consoleInput() throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, IOException {
        final Scanner scan = new Scanner(System.in);
        final String str;
        try {
            str = scan.nextLine();
        }
        finally {
            scan.close();
        }
        log.info("The command is accepted. Start parser");
        executeCommand(str);
    }

    private void readFile(final String fileName)
    {
        try
        {
            final File file = new File(fileName);
            try (FileReader fileReader = new FileReader(file)) {
                parseFile(fileReader);
            }
            log.info("Start file parser");
        } catch (final IOException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();    //TODO: информативности побольше
            log.log(Level.WARNING, "File problem", e);
        }
    }

    private Command commandParser(final String commandFirstWord) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, IOException {
        final Command command;
        final ClassesFinderInPackage instance = new ClassesFinderInPackage();
        final Set<Class<?>> classes = instance.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.arithmeticOperations");
        classes.addAll(instance.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.stackChangeOperations"));
        classes.addAll(instance.findAllClassesUsingClassLoader(
                "ru.karpov.StackCalculator.stackExtraOperations"));
        for(Class<?> cl : classes)
        {
            final CommandDescription annotation = cl.getAnnotation(CommandDescription.class);
            if(commandFirstWord.equals(annotation.commandSymbol()))
            {
                command = (Command) cl.getDeclaredConstructor().newInstance();  //TODO: обработка ошибки
                return command;
            }
        }
        return null;
    }

    public void executeCommand(final String commandString) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, IOException {
        final String[] words = commandString.split(" ");
        assert !words[0].isEmpty();
        final String commandFirstWord = words[0];
        final Command command = commandParser(commandFirstWord);
        assert command != null;
        log.info("Parser is complete. Start execute");
        try {
            command.execute(words, this.stack_, this.parameters_);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            log.log(Level.WARNING, "Command execute problem", e);
        }
    }
}
