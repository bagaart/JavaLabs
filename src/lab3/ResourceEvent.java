package lab3;

public class ResourceEvent {
    private final String message;

    public ResourceEvent(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
