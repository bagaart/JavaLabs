package lab3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

public class ResourceObserver implements Observer {
    private PrintWriter logWriter;

    public ResourceObserver(String logPath) throws IOException {
        File logFile = new File(logPath);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        this.logWriter = new PrintWriter(new FileWriter(logPath, true));
    }

    @Override
    public void update(Observable o, Object arg) {
        String message = "[EVENT] " + arg.toString();
        System.out.println(message);
        logWriter.println(message);
        logWriter.flush();
    }
}
