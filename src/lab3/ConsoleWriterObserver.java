package lab3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ConsoleWriterObserver implements Observer {
    private ArrayList<String> logWriter;

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
