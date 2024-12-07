package csci.ooad.grad;

public class Observer {
    public void notify(EventType eventType, String message) {
        System.out.println(eventType + " Event occurred: " + message);
    }
}