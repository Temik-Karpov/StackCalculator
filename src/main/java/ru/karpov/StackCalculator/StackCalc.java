package ru.karpov.StackCalculator;

import ru.karpov.StackCalculator.ArithmeticOperations.*;
import ru.karpov.StackCalculator.StackChangeOperations.Define;
import ru.karpov.StackCalculator.StackChangeOperations.Pop;
import ru.karpov.StackCalculator.StackChangeOperations.Push;
import ru.karpov.StackCalculator.StackExtraOperations.Comment;
import ru.karpov.StackCalculator.StackExtraOperations.Print;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StackCalc {
    static final Logger log = Logger.getGlobal();
    private final Stack stack_ = new Stack();
    private final Map<String, Double> params_ = new HashMap<>();

    public void fileParser(final FileReader fileReader) throws IOException {
        final BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            log.info("Parse command " + line);
            executeCommand(line);
            line = reader.readLine();
        }
    }

    public void start(final String fileName)
    {
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

    public void consoleInput()
    {
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
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.WARNING, "File problem", e);
        }
    }

    public void executeCommand(String str)
    {
        Command command = null;
        final String[] words = str.split(" ");
        final String comm = words[0];
        switch (comm) {
            case "DEFINE" -> command = new Define();
            case "PUSH" -> command = new Push();
            case "POP" -> command = new Pop();
            case "PRINT" -> command = new Print();
            case "+" -> command = new Plus();
            case "-" -> command = new Minus();
            case "*" -> command = new Multiplication();
            case "/" -> command = new Division();
            case "SQRT" -> command = new Sqrt();
            case "#" -> command = new Comment();
            default -> System.out.println("Incorrect command");
        }
        assert command != null;
        log.info("Parser is complete. Start execute");
        try {
            command.execute(words, this.stack_, this.params_);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            log.log(Level.WARNING, "ru.karpov.StackCalculator.Command execute problem", e);
        }
    }
}
