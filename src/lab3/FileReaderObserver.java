package lab3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class FileReaderObserver implements Observer {
    private ArrayList<String> logWriter;

    public FileReaderObserver(ArrayList<String> logs) throws IOException {
        logWriter = logs;
    }

    @Override
    public void update(Observable o, Object arg) {
        String message = "[EVENT] " + arg.toString();
        System.out.println(message);
        logWriter.add(message);
    }
}
