package csci.ooad.grad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventBus {

    private static EventBus instance;
    private final List<Observer> observers;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private EventBus() {
        observers = new ArrayList<>();
    }

    public static EventBus getInstance() {
        if (Objects.isNull(instance)) instance = new EventBus();
        return instance;
    }

    public void post(EventType eventType, String message) {
        for(Observer observer : observers) {
            observer.notify(eventType, message);
        }
    }
}