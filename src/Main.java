import java.io.IOException;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        log.addHandler(fh);
        log.setLevel(Level.ALL);
        log.info("Start program");
        StackCalc calc = new StackCalc();
        calc.start("input.txt");
    }
}
