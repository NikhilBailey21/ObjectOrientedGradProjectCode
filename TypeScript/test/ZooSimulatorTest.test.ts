import { Zoo } from '../src/Zoo';
import { ZooSimulator } from '../src/ZooSimulator';
import { Observer } from '../src/Observer';

describe('ZooSimulatorTest', () => {
    it('should simulate zoo turns correctly', () => {
        // Create a zoo with exhibits, cats, dogs, disguised dogs, people, and patrons
        const zoo = Zoo.Builder.getBuilder()
            .createAndAddExhibits(5)
            .createAndAddCats(6)
            .createAndAddDogs(7)
            .createAndAddDisguisedDogs(1)
            .createAndAddEnclosedPeople(2)
            .createAndAddPatrons(4)
            .build();

        // Create a simulator and attach an observer
        const simulator = new ZooSimulator(zoo);
        simulator.attach(new Observer());

        // Simulate 10 turns
        simulator.simulateTurns(10);
    });
});
