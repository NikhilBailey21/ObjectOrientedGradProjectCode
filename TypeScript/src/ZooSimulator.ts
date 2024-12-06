import { Zoo } from './Zoo'; // Assuming you have the Zoo class in the correct path
import { Observer } from './Observer'; // Assuming you have the Observer class in the correct path
import { EventBus } from './EventBus'; // Assuming you have the EventBus class in the correct path

class ZooSimulator {

    private zoo: Zoo.Zoo;

    constructor(zoo: Zoo.Zoo) {
        this.zoo = zoo;
    }

    public simulateTurns(numberOfTurns: number): void {
        for (let i = 0; i < numberOfTurns; i++) {
            this.zoo.takeTurn();
        }
    }

    public attach(observer: Observer): void {
        EventBus.getInstance().attach(observer);
    }
}

export { ZooSimulator };
