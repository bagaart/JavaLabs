package lab3;

public class ResourseEvent {
    private String message;

    public ResourseEvent(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
