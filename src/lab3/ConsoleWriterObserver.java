package lab3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ConsoleWriterObserver implements Observer {
    private final ArrayList<String> logWriter;

    public ConsoleWriterObserver(ArrayList<String> logs) throws IOException {
        logWriter = logs;
    }

    @Override
    public void update(Observable o, Object arg) {
        String message = "[EVENT] " + arg.toString();
        System.out.println(message);
        logWriter.add(message);
    }
}
