package csci.ooad.grad;

import org.junit.jupiter.api.Test;

public class ZooSimulatorTest {

    @Test
    public void testZooSimulator() {
        Zoo zoo = Zoo.Builder.getBuilder()
                .createAndAddExhibits(5)
                .createAndAddCats(6)
                .createAndAddDogs(7)
                .createAndAddDisguisedDogs(1)
                .createAndAddEnclosedPeople(2)
                .createAndAddPatrons(4)
                .Build();

        ZooSimulator simulator = new ZooSimulator(zoo);
        simulator.attach(new Observer());
        simulator.simulateTurns(10);
    }

}
