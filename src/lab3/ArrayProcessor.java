package lab3;

import java.util.Observable;

public class ArrayProcessor extends Observable {
    private int[] array;

    public void setArray(int[] array) {
        this.array = array;
        setChanged();
        notifyObservers(new ResourceEvent("Доступ к массиву"));
    }

    public int[] getArray() {
        setChanged();
        notifyObservers(new ResourceEvent("Чтение массива"));
        return array;
    }
}
