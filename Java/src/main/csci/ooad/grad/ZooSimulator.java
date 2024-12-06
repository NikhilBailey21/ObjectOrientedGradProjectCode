package csci.ooad.grad;

public class ZooSimulator {

    private final Zoo zoo;

    public ZooSimulator(Zoo zoo) {
        this.zoo = zoo;
    }

    public void simulateTurns(int numberOfTurns) {
        for (int i = 0; i < numberOfTurns; i++) {
            zoo.takeTurn();
        }
    }

    public void attach(Observer observer) {
        EventBus.getInstance().attach(observer);
    }
}