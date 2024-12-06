public class EventBus {

    private static EventBus instance;
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private EventBus() {
        ovbservers = new ArrayList<>();
    }

    private static EventBus getInstance() {
        if Objects.isNull(instance) instance = new EventBus();
        return instance;
    }

    public void Post(EventType eventType, String message) {
        for(Observer observer : observers) {
            observer.notify(eventType, message);
        }
    }
}