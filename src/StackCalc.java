import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackCalc {
    private Stack<Double> stack_ = new Stack<>();
    private Map<String, Double> params_ = new HashMap<>();

    public StackCalc(String fileName)
    {
        try
        {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            executeCommand(line);
            line = reader.readLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public StackCalc()
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            String str = scan.nextLine();
            executeCommand(str);
        }

    }

    private void executeCommand(String str)
    {
        Command command = null;
        String[] words = str.split(" ");
        String comm = words[0];
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
        try {
            command.execute(words, this.stack_, this.params_);
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
