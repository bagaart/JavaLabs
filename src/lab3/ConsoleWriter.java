package lab3;

import java.util.Observable;

public class ConsoleWriter extends Observable {
    public void write(String message) {
        setChanged();
        notifyObservers(new ResourseEvent("Вывод в консоль \n" + message));
    }
}
