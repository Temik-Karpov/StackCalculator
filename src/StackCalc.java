import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StackCalc {
    static final Logger log = Logger.getGlobal();
    private final ArrayList<Double> stack_ = new ArrayList<>();
    private final Map<String, Double> params_ = new HashMap<>();

    public void fileParser(FileReader fileReader) throws IOException {
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            log.info("Parse command " + line);
            executeCommand(line);
            line = reader.readLine();
        }
    }

    public void start(String fileName)
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
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        log.info("The command is accepted. Start parser");
        executeCommand(str);
    }

    public void readFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
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
