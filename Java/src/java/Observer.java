public class Observer {
    public void notify(EventType eventType, String message) {
        console.log(eventType " Event occurred: " + message);
    }
}