public class ZooSimulator {

    private Zoo zoo;

    public ZooSimulator(Zoo zoo) {
        this.zoo = zoo;
    }

    public simulateTurns(int numberOfTurns) {
        for (int i = 0; i < numberOfTurns; i++) {
            zoo.takeTurn();
        }
    }
}